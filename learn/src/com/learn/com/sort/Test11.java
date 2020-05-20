package com.learn.com.sort;

import java.util.ArrayList;
import java.util.List;

public class Test11 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		if(null != list) {
			for(int i = 0; i < list.size(); i ++) {
				System.out.println(list.get(i));
			}
			list.stream().forEach(str -> System.out.println(str));
		}
	}
}
