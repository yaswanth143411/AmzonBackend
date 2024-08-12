package com.asarit.amzon.controller;

import com.asarit.amzon.dto.ProductDTO;
import com.asarit.amzon.mapper.ProductMapper;
import com.asarit.amzon.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);

    }

    @PutMapping("/{productId}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long productId){
       return productService.updateProduct(productDTO,productId);
    }
    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts(){
        return productService.findAllProducts();
    }
    @GetMapping("/getProductById/{productId}")
    public ProductDTO getProductById(@PathVariable Long productId){
        return productMapper.toProductDTO(productService.findProductById(productId));
    }


}
