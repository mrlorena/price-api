package com.ecommerce.price.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.price.model.Price;
import com.ecommerce.price.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;

	public java.util.Optional<Price> findApplicablePrice(LocalDateTime date, int productId, int brandId) {
		return priceRepository.findApplicablePrice(date, productId, brandId).stream()
				.max((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()));
	}
}
