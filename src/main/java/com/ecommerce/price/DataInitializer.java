package com.ecommerce.price;

import java.math.BigDecimal;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.ecommerce.price.model.Price;
import com.ecommerce.price.repository.PriceRepository;
import com.ecommerce.price.utils.DateUtil;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private DateUtil dateUtil;

	public DataInitializer(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	@PostConstruct
	public void initData() {
		try {
			// Crear objetos Price para insertar en la base de datos H2
			Price price1 = new Price(1l, 35455l, 0, dateUtil.parseDate("2020-06-14-00.00.00"),
					dateUtil.parseDate("2020-12-31-23.59.59"), BigDecimal.valueOf(35.50), "EUR", 1);
			Price price2 = new Price(1l, 35455l, 1, dateUtil.parseDate("2020-06-14-15.00.00"),
					dateUtil.parseDate("2020-06-14-18.30.00"), BigDecimal.valueOf(25.45), "EUR", 2);
			Price price3 = new Price(1l, 35455l, 1, dateUtil.parseDate("2020-06-15-00.00.00"),
					dateUtil.parseDate("2020-06-15-11.00.00"), BigDecimal.valueOf(30.50), "EUR", 3);
			Price price4 = new Price(1l, 35455l, 1, dateUtil.parseDate("2020-06-15-16.00.00"),
					dateUtil.parseDate("2020-12-31-23.59.59"), BigDecimal.valueOf(38.95), "EUR", 4);

			// Guardar los objetos Price en la base de datos H2
			priceRepository.save(price1);
			priceRepository.save(price2);
			priceRepository.save(price3);
			priceRepository.save(price4);

			System.out.println("Datos iniciales cargados en la base de datos.");

		} catch (DataAccessException | ParseException e) {
			System.err.println("Error al inicializar la base de datos: " + e.getMessage());
		}
	}

}
