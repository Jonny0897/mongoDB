package com.project.shop.converter;

import com.project.shop.dto.ProductDTO;
import com.project.shop.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO mapToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product mapToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

}
