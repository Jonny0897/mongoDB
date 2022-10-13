package com.project.shop;

import com.project.shop.model.Product;
import com.project.shop.repository.ProductRepository;
import com.project.shop.service.ProductManagmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication{


	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
