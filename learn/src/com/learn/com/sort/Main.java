package com.learn.com.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
    	long start = System.currentTimeMillis();
//		Scanner sc = new Scanner(System.in);
        doit("", "123455");
        List<String> collect = list.stream().filter(x -> Integer.parseInt(x.substring(0, 2)) <= 23 && 
                        Integer.parseInt(x.substring(2, 4)) <= 59 && Integer.parseInt(x.substring(4, 6)) <= 59).collect(Collectors.toList());
        if(collect.size() == 0){
            System.out.println(0);
        }else{
            maxAndMin(collect);
        }
        System.out.println("花费时间为：" + (System.currentTimeMillis() - start));
    }

    public static void doit(String a, String b) {
        if (a.length() == 6) {
            list.add(a);
        } else {
            for (int i = 0; i < b.length(); i++) {
                String tempa = new String(a);
                String tempb = new String(b);
                doit(tempa + tempb.charAt(i), new StringBuilder(tempb)
                        .deleteCharAt(i).toString());
            }
        }
    }

    public static void maxAndMin(List<String> dates){
        List<String> dateList = dates.stream().distinct()
        		.sorted(Comparator.comparingInt(x -> Integer.parseInt(x.substring(4, 6))))
                .sorted(Comparator.comparingInt(x -> Integer.parseInt(x.substring(2, 4))))
                .sorted(Comparator.comparing(x -> Integer.parseInt(x.substring(0, 2))))
                .collect(Collectors.toList());
        String min = dateList.get(0);
        String max = dateList.get((dateList.size() - 1));
        System.out.println(min.substring(0, 2) + ":"+ min.substring(2,4) + ":"+ min.substring(4,6)+" "
                           + max.substring(0, 2) + ":"+ max.substring(2,4) + ":"+ max.substring(4,6));
    }
}
