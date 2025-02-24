package com.ecommerce.price.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.price.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query("SELECT p FROM Price p WHERE p.startDate <= :date AND p.endDate >= :date AND p.productId = :productId AND p.brandId = :brandId")
	List<Price> findApplicablePrice(@Param("date") LocalDateTime date, @Param("productId") int productId,
			@Param("brandId") int brandId);
}
