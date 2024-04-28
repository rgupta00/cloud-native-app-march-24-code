package com.productclient.service;

import com.productclient.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange("products")
public interface ProductServiceProxy2 {
    @GetExchange
    public ResponseEntity<List<ProductDto>> getAll();

    @GetExchange("{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id);

    @PostExchange
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto);


    @PutExchange("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,  @RequestBody ProductDto productDto);


    @DeleteExchange("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id);
}
