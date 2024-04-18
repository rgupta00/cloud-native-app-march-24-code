package com.productapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    //@Query annotation
    @Query("select p from Product p")
    public List<Product> getProducts();

    //updating queries
    @Transactional
    @Modifying
    @Query("update Product p set p.price=:price where p.id=:id")
    public void updatePr(@Param("price")BigDecimal bigDecimal, @Param("id") int id);

//    @Query("select p from Product p.cat=:cat")
//    public List<Product> getProductsByCat(@Param("cat")String cat);

//    @Query("select p.name from Product p.cat=:cat")
//    public List<String> getProductsByCat(@Param("cat")String cat);

//    @Query("select p.name from Product p.cat=:cat and p.price>:price")
//    public List<String> getProductsByCat(@Param("cat")String cat, @Param("price")BigDecimal price);

    //DSL for spring data
    public List<Product> findByName(String name);
    public List<Product> findByNameLike(String name);// "%"+name+"%"
    public List<Product> findByNameStartingWith(String name);
    public List<Product> findByNameIn(List<String> names);
    public List<Product> findByNameAndPrice(String name, BigDecimal price);
    public List<Product> findByNameOrPrice(String name, BigDecimal price);
}
