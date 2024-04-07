package com.busycoder.productapp.controller;

import com.busycoder.productapp.repo.Product;
import com.busycoder.productapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1")
@RestController//@Controller+ @ResponseBody(it trigger parser to convert java to json object)
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //----get all products
    //ResponseEnitty= data + http status code
    @GetMapping(path = "products", produces ={ MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products= productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @GetMapping(path = "products", produces ={ MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Product>> getAllV2(){
        List<Product> products= productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @Operation(summary = "Get a product by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content) })
    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.getById(id));
    }
    //add product
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        Product productAdded= productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
    }
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id,  @RequestBody Product product){
        Product productUpdated= productService.updateProduct(id, product);
        return ResponseEntity.ok().body(productUpdated);
    }
    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        Product productDeleted= productService.deleteProduct(id);
        //log4j
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}














