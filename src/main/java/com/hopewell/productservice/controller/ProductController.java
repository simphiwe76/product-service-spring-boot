package com.hopewell.productservice.controller;

import com.hopewell.productservice.model.Product;

import com.hopewell.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/create")
    public Product createProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping(value = "/all")
    public List<Product> getAllProducts(){
        return productService.retrieveAll();
    }

    @GetMapping(value = "/single-product/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.retrieveSingleProduct(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public List<Product> deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

}
