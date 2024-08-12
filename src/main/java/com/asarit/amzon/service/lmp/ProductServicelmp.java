package com.asarit.amzon.service.lmp;

import com.asarit.amzon.dto.ProductDTO;
import com.asarit.amzon.exceptions.ProductNotFoundException;
import com.asarit.amzon.mapper.ProductMapper;
import com.asarit.amzon.model.Product;
import com.asarit.amzon.repository.ProductRepository;
import com.asarit.amzon.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicelmp implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServicelmp(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
       Product product= productMapper.toProduct(productDTO);
        return productMapper.toProductDTO(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> findAllProducts() {
       return productRepository.findAll().stream()
                .map(
                        product -> new ProductDTO(
                                product.getId(),
                                product.getSku(),
                                product.getDescription(),
                                product.getPrice(),
                                product.getStock()
                        )
                ).toList();

    }

    @Override
    public Product findProductById(Long productId) {
        Optional<Product> byId = productRepository.findById(productId);
        if(byId.isEmpty()){
            throw new ProductNotFoundException("the product with this id "+productId+" is not found");
        }
        return byId.get();

    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {
        Product productFromDb=findProductById(productId);
        productFromDb.setDescription(productDTO.getDescription());
        productFromDb.setSku(productDTO.getSku());
        productFromDb.setStock(productDTO.getStock());
        productFromDb.setPrice(productDTO.getPrice());
        return productMapper.toProductDTO(productRepository.save(productFromDb));
    }

}
