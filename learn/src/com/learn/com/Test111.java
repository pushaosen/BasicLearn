package com.learn.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test111 {

	 @SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
        String name = "name|age";
        String[] ss = name.split("\\|");
        System.out.println(ss);
        
        String str = "1|1";
        
        List<String> list = Arrays.asList(str.split("\\|"));
        list.set(0, "2");
        System.out.println(list.toString());
        String result = String.join("|", list);
        System.out.println(result);
        
        String s = "jsy,tom,name";
        System.out.println(s.split(",")[0]);
        
        String sss = "1233";
        StringBuilder sdf = new StringBuilder();
        sdf.append(sss, 1, sss.length());
        System.out.println(sdf.toString());
        
        System.out.println(new Date().toLocaleString());
        System.out.println(new java.sql.Date(new Date().getTime()));
        System.out.println(new java.util.Date(new java.sql.Date(new Date().getTime()).getTime()));
        
        System.out.println(new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").parse("2018-12-12 12:24:45"));
        
        
        Date d1 = new Date();
        Date d2 = new Date();
        System.out.println(d1.before(d2));
        System.out.println(d1.getTime());
        System.out.println(d2.getTime() == d1.getTime());
        
        System.out.println(Integer.MIN_VALUE);
        
        
        
        System.out.println(0x20);
        int sss1 = ' ';
        System.out.println(sss1);
        
//        InputStream in = Resources.get
        FetchType eager = FetchType.EAGER;
        System.out.println(eager);
        System.out.println(eager.toString());
        
        
	 }
}
