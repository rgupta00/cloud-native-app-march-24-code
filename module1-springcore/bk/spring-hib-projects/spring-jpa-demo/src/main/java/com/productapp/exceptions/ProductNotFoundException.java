package com.productapp.exceptions;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -418616815711660617L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}
