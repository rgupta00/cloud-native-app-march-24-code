package com.productclient.controller;

import com.productclient.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "client")
public class RestClientControllerV1 {

    private RestTemplate restTemplate;

    @Autowired
    public RestClientControllerV1(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id){
//       ProductDto productDto= restTemplate.getForObject("http://localhost:8080/products/"+id, ProductDto.class);
//        return ResponseEntity.ok(productDto);
        ResponseEntity<ProductDto> forEntity = restTemplate.getForEntity("http://localhost:8080/products/", ProductDto.class);
       return forEntity;
    }

}
