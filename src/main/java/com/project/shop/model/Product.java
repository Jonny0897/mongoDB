package com.project.shop.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "products")
public class Product {

    @Id
    private final long id;
    private final String title;
    private final String author;
    private Double price;
    private final String type;

    private static long idT = 100;

    public Product(long id, String title, String author, double price, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }
}
