package com.learn.com.sort;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DateTimeUtil {

	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private DateTimeUtil() {}
    public static LocalDateTime toLocalDateTime(Long date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneId.systemDefault());
    }
    
    public static LocalDate toLocalDate(Long date) {
        return Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static long toLong(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime).getTime();
    }
    
    public static String formatLocalDateTime(LocalDateTime dateTime){
        return dateTime.format(dateTimeFormatter);
    }
    
    public static String formatLocalDateTime(Long dateTime){
        return toLocalDateTime(dateTime).format(dateTimeFormatter);
    }
    
    public static void main(String[] args) {
    	System.out.println(toLocalDateTime(System.currentTimeMillis()));
    	System.out.println(toLocalDate(System.currentTimeMillis()));
    	System.out.println(toLong(toLocalDateTime(System.currentTimeMillis())));
    	System.out.println(formatLocalDateTime(toLocalDateTime(System.currentTimeMillis())));
    	System.out.println(formatLocalDateTime(System.currentTimeMillis()));
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("name", "张三");
    	map.put("name", "张三");
    	System.out.println(map.size());
	}
    
}
