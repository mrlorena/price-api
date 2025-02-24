package com.ecommerce.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecommerce.price.utils.DateUtil;

@SpringBootApplication
public class PriceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApiApplication.class, args);
	}

	@Bean
	public DateUtil dateUtil() {
		return new DateUtil();
	}

}
