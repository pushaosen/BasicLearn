package com.learn.com.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Join {

	public static void main(String[] args) {
		join1();
	}
	
	public static void join1(){
        List<String> list = Arrays.asList("11","22","23");

        // 最传统写法：
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }
        
        System.out.println(sb.toString());

        // 如果想要加个分隔符，比如逗号，传统写法：
        sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));

            if(i < list.size() - 1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());

        // 使用commons-lang库写法, 其实这个已经够简单了，就这个功能而言，我很喜欢，而且最最常用：
//        System.out.println(StringUtils.join(list.toArray(), ","));

        // 进入jdk8时代：
        System.out.println(list.stream().collect(Collectors.joining()));
        // jdk8时代，加个分隔符：
        System.out.println(list.stream().collect(Collectors.joining(",")));
        
        // lambda表达式中的sort排序方法的使用
        List<String>  listDemo=new ArrayList<>();
        listDemo.add("q");
        listDemo.add("b");
        listDemo.add("y");
        listDemo.add("c");
        listDemo.stream().sorted((e1,e2)->e1.compareTo(e2)).forEach(System.out::print);
        
        System.out.println();
        
        List<String> ll = Arrays.asList("a", "a", "b");
        Set<Object> set = new HashSet<>();
        ll.forEach(s -> {
        	set.add(s);
        });
        
        System.out.println(set.size());
        
//        MathContext mc = new MathContext(4, RoundingMode.HALF_DOWN);
	    //精度为2，舍入模式为大于0.5进1，否则舍弃。
	    BigDecimal a = new BigDecimal(0.5);
	    BigDecimal b = new BigDecimal(0.2);
	    System.out.println(a.divide(b,1, BigDecimal.ROUND_HALF_UP));
        
    }
}
