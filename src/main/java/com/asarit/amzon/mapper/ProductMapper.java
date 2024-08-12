package com.asarit.amzon.mapper;

import com.asarit.amzon.dto.ProductDTO;
import com.asarit.amzon.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductDTO productDTO) {
        return  new Product(
                productDTO.getSku(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getStock()
                );
    }

    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getSku(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
    }
}
