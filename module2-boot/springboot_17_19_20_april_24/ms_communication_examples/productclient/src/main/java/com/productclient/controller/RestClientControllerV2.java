package com.productclient.controller;

import com.productclient.dto.ProductDto;
import com.productclient.service.ProductServiceProxy;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client2")
public class RestClientControllerV2 {

    private ProductServiceProxy productServiceProxy;

    @Autowired
    public RestClientControllerV2(ProductServiceProxy productServiceProxy) {
        this.productServiceProxy = productServiceProxy;
    }

    @GetMapping(path = "products")
    public ResponseEntity<List<ProductDto>> getAll(){
      return productServiceProxy.getAll();
    }

    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id){
        return productServiceProxy.getById(id);
    }
    //add product
    @PostMapping(path = "products")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
        return productServiceProxy.addProduct(productDto);
    }
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,  @RequestBody ProductDto productDto){
        return productServiceProxy.updateProduct(id, productDto);
    }
    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        return productServiceProxy.deleteById(id);
    }

}
