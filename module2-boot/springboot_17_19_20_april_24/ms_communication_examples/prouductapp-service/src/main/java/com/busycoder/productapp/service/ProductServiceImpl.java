package com.busycoder.productapp.service;

import com.busycoder.productapp.dto.ProductDto;
import com.busycoder.productapp.entities.Product;
import com.busycoder.productapp.exceptions.ProductNotFoundException;
import com.busycoder.productapp.repo.ProductRepo;
import com.busycoder.productapp.util.DtoConvertor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //SL=BL+CCC
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll().stream().map(DtoConvertor::toProductDto).toList();

    }

    @Override
    public ProductDto getById(int id) {
        return  productRepo.findById(id).map(DtoConvertor::toProductDto)
                .orElseThrow(()-> new ProductNotFoundException("product with id "+ id +" is not found"));

    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product=DtoConvertor.toProduct(productDto);
        productRepo.save(product);
        return DtoConvertor.toProductDto(product);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        ProductDto productDtoToUpdate= getById(id);
        productDtoToUpdate.setPrice(productDto.getPrice());
        Product product=DtoConvertor.toProduct(productDtoToUpdate);
         productRepo.save(product);
         return productDtoToUpdate;
    }

    @Override
    public ProductDto deleteProduct(int id) {
        ProductDto productToDelete= getById(id);
        Product product=DtoConvertor.toProduct(productToDelete);
         productRepo.delete(product);
         return productToDelete;
    }
}
