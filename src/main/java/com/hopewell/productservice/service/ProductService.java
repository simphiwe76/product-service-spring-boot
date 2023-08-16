package com.hopewell.productservice.service;

import com.hopewell.productservice.error.ProductNotFoundException;
import com.hopewell.productservice.model.Product;
import com.hopewell.productservice.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private  final ProductRepository productRepository;

    public Product addProduct(Product product) {
        product.setCreatedDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public List<Product> retrieveAll() {
        return productRepository.findAll();
    }

    public Product retrieveSingleProduct(Long id) {
        return  productRepository.
                findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
}
