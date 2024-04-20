package com.busycoder.productapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
//DTO
@Entity
@Table(name = "product_table")
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	private BigDecimal price;

	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	//private String productType;//EL, BOOKS ST custom annotation
}