package com.learn.com.sort;

import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
		String str = "100110010100001101";
		// 正则表达式，验证字符串是否全是数字
		Pattern pattern = Pattern.compile("\\d+");
		// 记录出现的次数
		int count = 0;
		// 代表0连续出现的次数
		int position1 = 1;
		// 代表1连续出现的次数
		int position2 = 1;
		// 如果满足全是数字的话，则进行下面的遍历，求出现的次数
        if(pattern.matcher(str).matches()) {
        	int len = str.length();
        	// 第一次循环，获取比较的最外层数字
        	for(int i = 0; i < len;) {
        		// 如果i==len - 1，表示最后一个数字，就不需要进行里层的循环了
        		if(i == len -1) {
        			// 打印输出
        			if(str.charAt(i) == '0') {
        				System.out.println(str.charAt(i) + "连续出现第" + position1 + "次的个数为：" + (++ count));
        			}else {
        				System.out.println(str.charAt(i) + "连续出现第" + position2 + "次的个数为：" + (++ count));
        			}
        			// 跳出外层循环
        			break;
            	}
        		// 内层循环
        		for(int j = i; j < len; j ++) {
        			// 如果外层数据等于内层数据，则计数器加1
        			if(str.charAt(i) == str.charAt(j)) {
        				count ++;
        			}else {
        				// 否则，就进行输出
        				if(str.charAt(i) == '0') {
        					System.out.println(str.charAt(i) + "连续出现第" + (position1 ++) + "次的个数为：" + (count ++));
            			}else {
            				System.out.println(str.charAt(i) + "连续出现第" + (position2 ++) + "次的个数为：" + (count ++));
            			}
        				// 将计数器置0，方便下次计数
        				count = 0;
        				// 外层索引等于内层索引，加快外层的循环，减少外层连续数字的比较
        				i = j;
        				// 跳出内层循环
        				break;
        			}
        		}
        	}
        }
	}
}