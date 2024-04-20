package com.busycoder.productapp.util;

import com.busycoder.productapp.dto.ProductDto;
import com.busycoder.productapp.entities.Product;

public class DtoConvertor {
    public static ProductDto toProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
    public static Product toProduct(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
