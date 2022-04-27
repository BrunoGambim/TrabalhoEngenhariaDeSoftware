package com.grupo4.ArenaCampestre.controllers.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static Date getDateNow() {
		return new Date(new java.util.Date().getTime());
	}
	
	public static String getFormattedDateNow() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(org.thymeleaf.util.DateUtils.createToday().getTime());
		return formattedDate;
	}
	
	public static Date dateFromString(String date) {
		String pattern = "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDate localDate = LocalDate.from(formatter.parse(date));
		return Date.valueOf(localDate);
	}
}
