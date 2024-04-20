package com.productclient.dto;

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
public class ProductDto {
	private Integer id;

	@NotEmpty(message = "{productDto.name.absent}")
	@Pattern( regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{product.name.invalid}")
	private String name;

	@NotNull(message = "{productDto.price.absent}")
	@Range(min = 10, max = 100000, message = "{product.price.invalid}")
	private BigDecimal price;

	public ProductDto(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	//private String productType;//EL, BOOKS ST custom annotation
}