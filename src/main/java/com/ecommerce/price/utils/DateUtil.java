package com.ecommerce.price.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtil {
	public LocalDateTime parseDate(String dateString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		Date date = formatter.parse(dateString);
		return LocalDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());
	}
}