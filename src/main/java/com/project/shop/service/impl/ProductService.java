package com.project.shop.service.impl;

import com.project.shop.model.Product;
import com.project.shop.repository.ProductRepository;
import com.project.shop.service.ProductManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductManagmentService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product p) {
        productRepository.save(p);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updatePrice(long id, double price) {
        productRepository.findAll().stream()
                .filter(p -> p.getId() == id)
                .peek(p -> p.setPrice(price));
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductsByAuthor(String author) {
        return productRepository.findAll().stream()
                .filter(p -> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isEmpty() {
        return productRepository.findAll().isEmpty();
    }

}
