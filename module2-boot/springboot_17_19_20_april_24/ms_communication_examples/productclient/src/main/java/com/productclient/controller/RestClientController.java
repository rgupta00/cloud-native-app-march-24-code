package com.productclient.controller;

import com.productclient.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@RestController
//@RequestMapping(path = "client")
public class RestClientController {

//    private RestTemplate template;
//
//    @Autowired
//    public RestClientController(RestTemplate template) {
//        this.template = template;
//    }
//    @GetMapping(path = "products")
//    public List<?> getAll(){
//        return  template.getForObject("http://localhost:8080/products", List.class);
//    }
//
//    //get by id
//    @GetMapping(path = "products/{id}")
//    public ResponseEntity<ProductDto> getById(@PathVariable int id){
//        ProductDto productDto=template.getForObject("http://localhost:8080/products/"+id, ProductDto.class);
//        return ResponseEntity.ok(productDto);
//
//    }

}
