package com.project.shop.service;

import com.project.shop.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface ProductManagmentService {

    void addProduct(Product p);

    List<Product> getAllProducts();

    void deleteProduct(long id);

    void updatePrice(long id, Product product);

    Optional<Product> getProductById(long id);

    List<Product> getProductsByAuthor(String author);

    boolean isEmpty();

}
