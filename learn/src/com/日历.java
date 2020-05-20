package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("unused")
public class »’¿˙ {
	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(format.parse("2020-01-01"));
        calendar.add(Calendar.DAY_OF_YEAR, -7 * 1);
        
		int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int month = calendar.get(Calendar.DAY_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
	}

}
