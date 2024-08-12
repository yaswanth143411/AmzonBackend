package com.asarit.amzon.service;

import com.asarit.amzon.dto.ProductDTO;
import com.asarit.amzon.model.Product;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> findAllProducts();

    Product findProductById(Long productId);

    ProductDTO updateProduct(ProductDTO productDTO, Long productId);
}
