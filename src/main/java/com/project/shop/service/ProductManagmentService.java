package com.project.shop.service;

import com.project.shop.model.Product;

import java.util.List;

public interface ProductManagmentService {

    void addProduct(Product p);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

    void updatePrice(Long id,double price);

    Product getProductById(Long id);

    List<Product> getProductsByAuthor(String author);

    boolean isEmpty();

    boolean isPresent(Long id);

}
