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

        // �ͳд����
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }
        
        System.out.println(sb.toString());

        // �����Ҫ�Ӹ��ָ��������綺�ţ���ͳд����
        sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));

            if(i < list.size() - 1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());

        // ʹ��commons-lang��д��, ��ʵ����Ѿ������ˣ���������ܶ��ԣ��Һ�ϲ������������ã�
//        System.out.println(StringUtils.join(list.toArray(), ","));

        // ����jdk8ʱ����
        System.out.println(list.stream().collect(Collectors.joining()));
        // jdk8ʱ�����Ӹ��ָ�����
        System.out.println(list.stream().collect(Collectors.joining(",")));
        
        // lambda���ʽ�е�sort���򷽷���ʹ��
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
	    //����Ϊ2������ģʽΪ����0.5��1������������
	    BigDecimal a = new BigDecimal(0.5);
	    BigDecimal b = new BigDecimal(0.2);
	    System.out.println(a.divide(b,1, BigDecimal.ROUND_HALF_UP));
        
    }
}
