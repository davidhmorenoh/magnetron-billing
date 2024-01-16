-- Crear base de datos
create database billing;

-- Usar base de datos
use billing;

-- Crear la tabla Persona
CREATE TABLE person
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255),
    last_name     VARCHAR(255),
    document_type VARCHAR(50),
    document      VARCHAR(20)
);

-- Crear la tabla Producto
CREATE TABLE product
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    description     VARCHAR(255),
    price           DECIMAL(10, 2),
    cost            DECIMAL(10, 2),
    unit_of_measure VARCHAR(50)
);

-- Crear la tabla Fact_Encabezado
CREATE TABLE invoice_header
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    number    INT,
    date      DATE,
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES person (id)
);

-- Crear la tabla Fact_Detalle
CREATE TABLE invoice_detail
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    line              INT,
    quantity          INT,
    product_id        INT,
    invoice_header_id INT,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (invoice_header_id) REFERENCES invoice_header (id)
);

-- Crear la vista para obtener la lista de cada persona con el total facturado, de cada una, si no tiene facturas, debe obtener la persona y facturado = 0
CREATE VIEW ViewTotalBilledPerPerson AS
SELECT p.id,
       p.name,
       p.last_name,
       COALESCE(SUM(fd.quantity * pr.price), 0) AS total_billed
FROM person p
         LEFT JOIN invoice_header fe ON p.id = fe.person_id
         LEFT JOIN invoice_detail fd ON fe.id = fd.invoice_header_id
         LEFT JOIN product pr ON fd.product_id = pr.id
GROUP BY p.id, p.name, p.last_name;

-- Crear la vista para obtener la lista de la persona que haya comprado el producto más caro
CREATE VIEW ViewPersonBuysMoreExpensiveProduct AS
SELECT DISTINCT p.id     AS person_id,
                p.name,
                p.last_name,
                pr.id    AS product_id,
                pr.description,
                pr.price AS most_expensive_product_price
FROM person p
         JOIN invoice_header fe ON p.id = fe.person_id
         JOIN invoice_detail fd ON fe.id = fd.invoice_header_id
         JOIN product pr ON fd.product_id = pr.id
WHERE pr.price = (SELECT MAX(price) FROM product);

-- Crear la vista para obtener la lista de los productos según su cantidad facturada en orden descendente
CREATE VIEW ViewProductsByInvoicedQuantity AS
SELECT pr.id, pr.description, SUM(fd.quantity) AS amount_billed
FROM product pr
         LEFT JOIN invoice_detail fd ON pr.id = fd.product_id
GROUP BY pr.id, pr.description
ORDER BY amount_billed DESC;

-- Crear la vista para obtener la lista de los productos según su utilidad generados por facturación
CREATE VIEW ViewProductsByUtility AS
SELECT pr.id                                                   as product_id,
       pr.description,
       ie.number                                               as invoice_number,
       SUM((id.quantity * pr.price) - (id.quantity * pr.cost)) AS profit_generated
FROM product pr
         LEFT JOIN
     invoice_detail id ON pr.id = id.product_id
         LEFT JOIN
     invoice_header ie ON id.invoice_header_id = ie.id
GROUP BY pr.id, pr.description, ie.number;

-- Crear la vista para obtener la lista de los productos y el margen de ganancia de cada uno según su facturación
CREATE VIEW ViewProductsWithProfitMargin AS
SELECT pr.id                                                      as product_id,
       pr.description,
       ie.number                                                  as invoice_number,
       SUM(fd.quantity * pr.price)                                AS total_revenue,
       SUM(fd.quantity * pr.cost)                                 AS total_cost,
       (SUM(fd.quantity * pr.price) - SUM(fd.quantity * pr.cost)) AS profit_margin
FROM product pr
         LEFT JOIN
     invoice_detail fd ON pr.id = fd.product_id
         LEFT JOIN
     invoice_header ie ON fd.invoice_header_id = ie.id
GROUP BY pr.id, pr.description, ie.number;

-- Insertar datos en la tabla Persona
INSERT INTO person (id, name, last_name, document_type, document)
VALUES (1, 'Juan', 'Pérez', 'DNI', '12345678'),
       (2, 'Ana', 'Gómez', 'CI', '87654321'),
       (3, 'Carlos', 'López', 'Pasaporte', 'ABCD1234');

-- Insertar datos en la tabla Producto
INSERT INTO product (id, description, price, cost, unit_of_measure)
VALUES (1, 'Laptop', 1200.00, 800.00, 'Unidad'),
       (2, 'Smartphone', 600.00, 400.00, 'Unidad'),
       (3, 'Impresora', 300.00, 200.00, 'Unidad');

-- Insertar datos en la tabla Fact_Encabezado
INSERT INTO invoice_header (id, number, date, person_id)
VALUES (1, 1001, '2024-01-01', 1),
       (2, 1002, '2024-02-01', 2),
       (3, 1003, '2024-03-01', 3);

-- Insertar datos en la tabla Fact_Detalle
INSERT INTO invoice_detail (id, line, quantity, product_id, invoice_header_id)
VALUES (1, 1, 2, 1, 1),
       (2, 2, 3, 2, 2),
       (3, 1, 1, 3, 3),
       (4, 2, 2, 1, 3);

-- Consultar las vistas creadas
SELECT *
FROM ViewTotalBilledPerPerson;
SELECT *
FROM ViewPersonBuysMoreExpensiveProduct;
SELECT *
FROM ViewProductsByInvoicedQuantity;
SELECT *
FROM ViewProductsByUtility;
SELECT *
FROM ViewProductsWithProfitMargin;

-- Eliminar la base de datos
drop database billing;