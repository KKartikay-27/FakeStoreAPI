package com.example.productservicesst.services;

import com.example.productservicesst.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
