package com.productapp.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;
    private Product product;

    @BeforeEach
    void setUp() {
        product=new Product("laptop", 120000);
    }

    @Test
    @Rollback(value = true)
    public void givenProductObjectWhenSaveReturnProductObject(){
        Product productSaved=productRepo.save(product);
        assertThat(productSaved).isNotNull();
        assertThat(productSaved.getId()).isGreaterThan(0);
    }
    @DisplayName("JUnit test for get all employees operation")
    @Test
    public void givenProductList_whenFindAll_thenProductList(){
        //given
        Product p1=new Product("laptop",120000);
        Product p2=new Product("laptop cover",1200);
        productRepo.save(p1);
        productRepo.save(p2);
        // when -  action or the behaviour that we are going test
        List<Product> productList=productRepo.findAll();
        // then - verify the output
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(2);
    }
    @DisplayName("JUnit test for get product by id operation")
    @Test
    public void givenProductObject_whenFindById_thenReturnProductObject(){
        // given - precondition or setup
        Product p1=new Product("laptop",120000);
        productRepo.save(p1);

        // when -  action or the behaviour that we are going test
        Product productDB = productRepo.findById(p1.getId()).get();
        // then - verify the output
        assertThat(productDB).isNotNull();
    }
    @DisplayName("JUnit test for update product operation")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee(){
        // given - precondition or setup
        Product p1=new Product("laptop",120000);
        productRepo.save(p1);
        // when -  action or the behaviour that we are going test
        Product savedProduct = productRepo.findById(p1.getId()).get();
        savedProduct.setPrice(130000);
        Product updatedProduct =  productRepo.save(savedProduct);

        assertThat(updatedProduct.getPrice()).isEqualTo(130000);
    }

    @DisplayName("JUnit test for delete product operation")
    @Test
    public void givenProductObject_whenDelete_thenRemoveProduct(){
        // given - precondition or setup
        Product p1=new Product("laptop",120000);
        productRepo.save(p1);

        // when -  action or the behaviour that we are going test
        productRepo.deleteById(p1.getId());
        Optional<Product> employeeOptional = productRepo.findById(product.getId());

        // then - verify the output
        assertThat(employeeOptional).isEmpty();
    }



    @AfterEach
    void tearDown() {
    }
}