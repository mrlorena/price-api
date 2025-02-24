package com.ecommerce.price.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.price.exceptions.PriceNotFoundException;
import com.ecommerce.price.model.Price;
import com.ecommerce.price.service.PriceService;

@RestController
@RequestMapping("/api/price")
public class PriceController {

	@Autowired
	private PriceService priceService;

	@GetMapping
	public Price getPrice(@RequestParam LocalDateTime date, @RequestParam int productId, @RequestParam int brandId) {
		return priceService.findApplicablePrice(date, productId, brandId).orElseThrow(() -> new PriceNotFoundException(
				"No price found for product " + productId + " and brand " + brandId + " at date " + date));
	}

	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<String> handlePriceNotFoundException(PriceNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
