package com.example.stockmanager.controller;

import com.example.stockmanager.entity.Product;
import com.example.stockmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}