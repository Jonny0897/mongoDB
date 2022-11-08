package com.project.shop.dto;

import lombok.*;

@Data
public class ProductDTO {

    private Long id;
    private String title;
    private String author;
    private Double price;
    private String type;

}
