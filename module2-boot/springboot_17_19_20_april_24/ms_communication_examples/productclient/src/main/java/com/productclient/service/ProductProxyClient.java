package com.productclient.service;

import com.productclient.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "productProxyClient", url = "http://localhost:8080/products")
public interface ProductProxyClient {
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll();

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id);

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto);

    @PutMapping(path = "{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,  @RequestBody ProductDto productDto);

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id);
}
