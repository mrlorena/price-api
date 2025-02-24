package com.ecommerce.price;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetPriceAt10amDay14() throws Exception {
		mockMvc.perform(get("/api/price").param("date", "2020-06-14T10:00:00").param("productId", "35455")
				.param("brandId", "1")).andExpect(status().isOk()).andExpect(jsonPath("$.price").value(35.50));
	}

	@Test
	void testGetPriceAt16amDay14() throws Exception {
		mockMvc.perform(get("/api/price").param("date", "2020-06-14T16:00:00").param("productId", "35455")
				.param("brandId", "1")).andExpect(status().isOk()).andExpect(jsonPath("$.price").value(25.45));
	}

	@Test
	void testGetPriceAt21amDay14() throws Exception {
		mockMvc.perform(get("/api/price").param("date", "2020-06-14T21:00:00").param("productId", "35455")
				.param("brandId", "1")).andExpect(status().isOk()).andExpect(jsonPath("$.price").value(35.50));
	}

	@Test
	void testGetPriceAt10amDay15() throws Exception {
		mockMvc.perform(get("/api/price").param("date", "2020-06-15T10:00:00").param("productId", "35455")
				.param("brandId", "1")).andExpect(status().isOk()).andExpect(jsonPath("$.price").value(30.50));
	}

	@Test
	void testGetPriceAt21amDay16() throws Exception {
		mockMvc.perform(get("/api/price").param("date", "2020-06-16T21:00:00").param("productId", "35455")
				.param("brandId", "1")).andExpect(status().isOk()).andExpect(jsonPath("$.price").value(38.95));
	}

	@Test
	void testPriceNotFound() throws Exception {
		mockMvc.perform(get("/api/price").param("date", "2023-01-01T00:00:00").param("productId", "99999")
				.param("brandId", "99")).andExpect(status().isNotFound());
	}

	@Test
	void testGetHighestPriorityPrice() throws Exception {
		mockMvc.perform(get("/api/price").param("date", "2020-06-14T16:00:00").param("productId", "35455")
				.param("brandId", "1")).andExpect(status().isOk()).andExpect(jsonPath("$.price").value(25.45));
	}

}
