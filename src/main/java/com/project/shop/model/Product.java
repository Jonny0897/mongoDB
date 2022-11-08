package com.project.shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String type;
    private int printEd;

    private static Long idT = 100L;

    public Product(Long id, String title, String author, double price, String type, int printEd) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.type = type;
        this.printEd = printEd;
    }

    public Product(){
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrintEd() {
        return printEd;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


    public String getAuthor() {
        return author;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrintEd(int printEd) {
        this.printEd = printEd;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
