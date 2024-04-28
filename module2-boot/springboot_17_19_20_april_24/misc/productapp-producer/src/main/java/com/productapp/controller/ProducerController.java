package com.productapp.controller;

import com.productapp.dto.Product;
import com.productapp.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

	@Autowired
	private ProduceService produceService;
	@GetMapping("producer/{message}")
	public String callProducer(@PathVariable String message) {
		for(int i=0;i<10000;i++) {
			produceService.produce(message+ " "+i);
		}
		return "ok";
	}
}