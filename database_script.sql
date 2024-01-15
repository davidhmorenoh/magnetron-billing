-- Crear base de datos
create database billing;

-- Usar base de datos
use billing;

-- Crear la tabla Persona
CREATE TABLE Persona
(
    Per_ID            INT PRIMARY KEY,
    Per_Nombre        VARCHAR(255),
    Per_Apellido      VARCHAR(255),
    Per_TipoDocumento VARCHAR(50),
    Per_Documento     VARCHAR(20)
);

-- Crear la tabla Producto
CREATE TABLE Producto
(
    Prod_ID          INT PRIMARY KEY,
    Prod_Descripcion VARCHAR(255),
    Prod_Precio      DECIMAL(10, 2),
    Prod_Costo       DECIMAL(10, 2),
    Prod_UM          VARCHAR(50)
);

-- Crear la tabla Fact_Encabezado
CREATE TABLE Fact_Encabezado
(
    FEnc_ID     INT PRIMARY KEY,
    FEnc_Numero INT,
    FEnc_Fecha  DATE,
    zPer_ID     INT,
    FOREIGN KEY (zPer_ID) REFERENCES Persona (Per_ID)
);

-- Crear la tabla Fact_Detalle
CREATE TABLE Fact_Detalle
(
    FDet_ID       INT PRIMARY KEY,
    FDet_Linea    INT,
    FDet_Cantidad INT,
    zProd_ID      INT,
    zFEnc_ID      INT,
    FOREIGN KEY (zProd_ID) REFERENCES Producto (Prod_ID),
    FOREIGN KEY (zFEnc_ID) REFERENCES Fact_Encabezado (FEnc_ID)
);

-- Crear la vista para obtener la lista de cada persona con el total facturado, de cada una, si no tiene facturas, debe obtener la persona y facturado = 0
-- Consultar y refactorizar
CREATE VIEW Vista_TotalFacturadoPorPersona AS
SELECT p.Per_ID,
       p.Per_Nombre,
       p.Per_Apellido,
       COALESCE(SUM(fd.FDet_Cantidad * pr.Prod_Precio), 0) AS TotalFacturado
FROM Persona p
         LEFT JOIN Fact_Encabezado fe ON p.Per_ID = fe.zPer_ID
         LEFT JOIN Fact_Detalle fd ON fe.FEnc_ID = fd.zFEnc_ID
         LEFT JOIN Producto pr ON fd.zProd_ID = pr.Prod_ID
GROUP BY p.Per_ID, p.Per_Nombre, p.Per_Apellido;

-- Crear la vista para obtener la lista de la persona que haya comprado el producto más caro
CREATE VIEW Vista_PersonaCompraProductoMasCaro AS
SELECT p.Per_ID,
       p.Per_Nombre,
       p.Per_Apellido,
       pr.Prod_ID,
       pr.Prod_Descripcion,
       pr.Prod_Precio AS PrecioProductoMasCaro
FROM Persona p
         JOIN Fact_Encabezado fe ON p.Per_ID = fe.zPer_ID
         JOIN Fact_Detalle fd ON fe.FEnc_ID = fd.zFEnc_ID
         JOIN Producto pr ON fd.zProd_ID = pr.Prod_ID
WHERE pr.Prod_Precio = (SELECT MAX(Prod_Precio) FROM Producto);

-- Crear la vista para obtener la lista de los productos según su cantidad facturada en orden descendente
CREATE VIEW Vista_ProductosPorCantidadFacturada AS
SELECT pr.Prod_ID, pr.Prod_Descripcion, SUM(fd.FDet_Cantidad) AS CantidadFacturada
FROM Producto pr
         LEFT JOIN Fact_Detalle fd ON pr.Prod_ID = fd.zProd_ID
GROUP BY pr.Prod_ID, pr.Prod_Descripcion
ORDER BY CantidadFacturada DESC;

-- Crear la vista para obtener la lista de los productos según su utilidad generados por facturación
-- Consultar y refactorizar
CREATE VIEW Vista_ProductosPorUtilidad AS
SELECT pr.Prod_ID,
       pr.Prod_Descripcion,
       SUM((fd.FDet_Cantidad * pr.Prod_Precio) - (fd.FDet_Cantidad * pr.Prod_Costo)) AS UtilidadGenerada
FROM Producto pr
         LEFT JOIN Fact_Detalle fd ON pr.Prod_ID = fd.zProd_ID
GROUP BY pr.Prod_ID, pr.Prod_Descripcion;

-- Crear la vista para obtener la lista de los productos y el margen de ganancia de cada uno según su facturación
-- Consultar y refactorizar
CREATE VIEW Vista_ProductosConMargenDeGanancia AS
SELECT pr.Prod_ID,
       pr.Prod_Descripcion,
       SUM(fd.FDet_Cantidad * pr.Prod_Precio)                                           AS IngresosTotales,
       SUM(fd.FDet_Cantidad * pr.Prod_Costo)                                            AS CostoTotal,
       (SUM(fd.FDet_Cantidad * pr.Prod_Precio) - SUM(fd.FDet_Cantidad * pr.Prod_Costo)) AS MargenDeGanancia
FROM Producto pr
         LEFT JOIN Fact_Detalle fd ON pr.Prod_ID = fd.zProd_ID
GROUP BY pr.Prod_ID, pr.Prod_Descripcion;

-- Insertar datos en la tabla Persona
INSERT INTO Persona (Per_ID, Per_Nombre, Per_Apellido, Per_TipoDocumento, Per_Documento)
VALUES (1, 'Juan', 'Pérez', 'DNI', '12345678'),
       (2, 'Ana', 'Gómez', 'CI', '87654321'),
       (3, 'Carlos', 'López', 'Pasaporte', 'ABCD1234');

-- Insertar datos en la tabla Producto
INSERT INTO Producto (Prod_ID, Prod_Descripcion, Prod_Precio, Prod_Costo, Prod_UM)
VALUES (1, 'Laptop', 1200.00, 800.00, 'Unidad'),
       (2, 'Smartphone', 600.00, 400.00, 'Unidad'),
       (3, 'Impresora', 300.00, 200.00, 'Unidad');

-- Insertar datos en la tabla Fact_Encabezado
INSERT INTO Fact_Encabezado (FEnc_ID, FEnc_Numero, FEnc_Fecha, zPer_ID)
VALUES (1, 1001, '2024-01-01', 1),
       (2, 1002, '2024-02-01', 2),
       (3, 1003, '2024-03-01', 3);

-- Insertar datos en la tabla Fact_Detalle
INSERT INTO Fact_Detalle (FDet_ID, FDet_Linea, FDet_Cantidad, zProd_ID, zFEnc_ID)
VALUES (1, 1, 2, 1, 1),
       (2, 2, 3, 2, 2),
       (3, 1, 1, 3, 3),
       (4, 2, 2, 1, 3);

-- Consultar las vistas creadas
SELECT *
FROM Vista_TotalFacturadoPorPersona;
SELECT *
FROM Vista_PersonaCompraProductoMasCaro;
SELECT *
FROM Vista_ProductosPorCantidadFacturada;
SELECT *
FROM Vista_ProductosPorUtilidad;
SELECT *
FROM Vista_ProductosConMargenDeGanancia;