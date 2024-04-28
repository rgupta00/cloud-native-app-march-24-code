//package com.productclient.controller;
//
//import com.productclient.dto.ProductDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping(path = "client3")
//public class RestClientControllerV3 {
//
//    private WebClient webClient;
//
//   @Autowired
//    public RestClientControllerV3(WebClient webClient) {
//        this.webClient = webClient;
//    }
//
//    //get by id
//    @GetMapping(path = "products/{id}")
//    public ResponseEntity<ProductDto> getById(@PathVariable int id){
////
////        Mono<ProductDto> productDtoMono = webClient.get()
////                .uri("http://localhost:8080/products/" + id)
////                .retrieve().bodyToMono(ProductDto.class);
//
//        ProductDto productDto=webClient.get()
//                .uri("http://localhost:8080/products/"+id)
//                .retrieve().bodyToMono(ProductDto.class).block();
//       return ResponseEntity.ok(productDto);
//    }
//
//}
