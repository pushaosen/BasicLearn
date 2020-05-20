package com.learn.com.sort;

import java.text.NumberFormat;
import java.text.ParseException;

public class DeferredResultHolder {
	
//	private Map<String, Defe>
	
	public static void main(String[] args) throws ParseException {
		NumberFormat numberFormat = NumberFormat.getPercentInstance();
        Number parse = numberFormat.parse("50.88%");
        System.out.println(parse.doubleValue());
        numberFormat.setMinimumFractionDigits(1);
        System.out.println(numberFormat.format(parse.doubleValue()));
		System.out.println(fun2());
	}
	
	private static String fun() {
		System.out.println("¹þ¹þ¹þ");
		
		System.exit(1);
		
		return "nini";
	}
	
	private static String fun2() {
		return fun();
	}

}
