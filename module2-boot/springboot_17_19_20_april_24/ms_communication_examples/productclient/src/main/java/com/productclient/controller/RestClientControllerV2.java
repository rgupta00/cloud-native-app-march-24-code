package com.productclient.controller;

import com.productclient.dto.ProductDto;
import com.productclient.service.ProductProxyClient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class RestClientControllerV2 {

    private ProductProxyClient productProxyClient;

    @Autowired
    public RestClientControllerV2(ProductProxyClient productProxyClient) {
        this.productProxyClient = productProxyClient;
    }

    @GetMapping(path = "products")
    public ResponseEntity<List<ProductDto>> getAll(){
      return productProxyClient.getAll();
    }

    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id){
        return productProxyClient.getById(id);
    }
    //add product
    @PostMapping(path = "products")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
        return productProxyClient.addProduct(productDto);
    }
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,  @RequestBody ProductDto productDto){
        return productProxyClient.updateProduct(id, productDto);
    }
    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        return productProxyClient.deleteById(id);
    }

}
