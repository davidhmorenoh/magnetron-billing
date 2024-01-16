package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ProductDTO;
import com.magnetron.billing.domain.entities.ProductEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ProductMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return productMapper.toDTOList(products);
    }

    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDTO);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity product = productRepository.save(productMapper.toEntity(productDTO));
        return productMapper.toDTO(product);
    }

    public Optional<ProductDTO> updateProduct(Long id, ProductDTO updatedProductDTO) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setDescription(updatedProductDTO.getDescription());
            existingProduct.setPrice(updatedProductDTO.getPrice());
            existingProduct.setCost(updatedProductDTO.getCost());
            existingProduct.setUnitOfMeasure(updatedProductDTO.getUnitOfMeasure());

            ProductEntity updatedProduct = productRepository.save(existingProduct);
            return productMapper.toDTO(updatedProduct);
        });
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}