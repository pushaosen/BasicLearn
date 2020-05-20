package com.learn.com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Time {

	/**
	 * 申明变量
	 */
	private static List<Integer> list = new ArrayList<Integer>();
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
	@SuppressWarnings("unused")
	private static final Scanner input=new Scanner(System.in);
	
	private static StringBuilder sdf = new StringBuilder(); 
	
	private static final int count = 6;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// 获取数字
		getNumber();
		// 进行排序
		list.sort((a, b) -> a - b);
		// 进行时间组转
		System.out.println("输入的6个数字为：" + list.toString());
		if(list.size() < count) {
			System.out.println("数据不合适！");
		}else {
			getData();
		}
		System.out.println("花费时间为：" + (System.currentTimeMillis() - start));
	}
	
	/**
	 * 组装数据
	 */
	private static void getData() {
		// 用来记录拼接数据的索引
		List<Integer> index = new ArrayList<Integer>();
		// 组装数据
		if(panDuan()) {
			// 组装最小的时间
			//1、组装小时
			sdf.append(list.get(0)).append(list.get(1));
			//2、组装
			sdf.append(":").append(list.get(2));
			if(list.get(4) > 6) {
				sdf.append(list.get(4)).append(":").append(list.get(3)).append(list.get(5));
			}else {
				sdf.append(list.get(3)).append(":").append(list.get(4)).append(list.get(5));
			}
			sdf.append(" ");
			// 组装最大的时间
			counter.set(0);
			while(counter.intValue() < count) {
				for(int i = list.size() - 1; i >= 0; i --) {
					Integer temp = list.get(i);
					// 拼装第一个
					if(!index.contains(i)) {
						if(temp <= 2 && index.size() == 0) {
							sdf.append(temp);
							index.add(i);
							counter.incrementAndGet();
							break;
						}
						// 拼装第二个
						if(temp <= 3 && index.size() == 1) {
							sdf.append(temp);
							index.add(i);
							counter.incrementAndGet();
							break;
						}
						// 拼装第三个
						if(temp <= 5 && index.size() == 2) {
							sdf.append(":");
							sdf.append(temp);
							counter.incrementAndGet();
							index.add(i);
							break;
						}
						// 拼装第四个
						if(temp <= 5 && index.size() == 3) {
							sdf.append(temp);
							counter.incrementAndGet();
							index.add(i);
							break;
						}
						// 拼装第五个
						if(index.size() == 4) {
							sdf.append(":");
							sdf.append(temp);
							counter.incrementAndGet();
							index.add(i);
							break;
						}
						// 拼装第六个
						if(index.size() == 5) {
							sdf.append(temp);
							counter.incrementAndGet();
							break;
						}
					}
				}
			}
			System.out.println("结果为：" + sdf.toString());
		}else {
			System.out.println("结果为：" + 0);
		}
	}
	
	/**
	 * 进行数据判断
	 * @return
	 */
	private static boolean panDuan() {
		if(list.get(0) > 2 || list.get(1) > 3 || list.get(2) > 6 || list.get(3) > 6) {
			return false;
		}
		return true;
	}
	
	/**
	 * 获取数据
	 */
	private static void getNumber() {
        String num;
        // 进行自旋操作
        num="123455";
        char[] charArray = num.toCharArray();
        for(char c : charArray) {
        	if(list.size() > 6) {
        		
        	}else {
        		list.add(Integer.parseInt(c + ""));
        	}
        }
//        while(counter.intValue() < count) {
//        	System.out.println("请输入整数：");
//        	if(input.hasNextInt()){
//                num=input.next();
//                Integer temp = Integer.parseInt(num);
//                if(temp < 0 || temp > 10) {
//                	System.out.println("请输入数字在0-9之间：");
//                }else {
//                	counter.incrementAndGet();  
//                    list.add(temp);
//                }
//            }else {
//                num=input.next();
//                System.out.println("不是数字，请重新输入：");
//            }
//        }
	}
	
}