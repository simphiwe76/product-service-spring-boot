package com.hopewell.productservice.service;

import com.hopewell.productservice.model.Address;
import com.hopewell.productservice.model.Manufacture;
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

        Address address = new Address("sdsdsds");
        Product product1 = new Product(
                null,product.getName(),
                product.getDescription(),
                product.getCategory(), product.getCreatedDate()
                ,product.getPrice(),new  Manufacture("South Africa","Newcastle"),address);
        return productRepository.save(product1);
    }

    public List<Product> retrieveAll() {
        return productRepository.findAll();
    }

    public Product retrieveSingleProduct(Long id) {
        return  productRepository.
                findById(id).orElseThrow();
    }

    public List<Product> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
}
