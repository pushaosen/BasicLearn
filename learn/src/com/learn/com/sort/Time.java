package com.learn.com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Time {

	/**
	 * ��������
	 */
	private static List<Integer> list = new ArrayList<Integer>();
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
	@SuppressWarnings("unused")
	private static final Scanner input=new Scanner(System.in);
	
	private static StringBuilder sdf = new StringBuilder(); 
	
	private static final int count = 6;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// ��ȡ����
		getNumber();
		// ��������
		list.sort((a, b) -> a - b);
		// ����ʱ����ת
		System.out.println("�����6������Ϊ��" + list.toString());
		if(list.size() < count) {
			System.out.println("���ݲ����ʣ�");
		}else {
			getData();
		}
		System.out.println("����ʱ��Ϊ��" + (System.currentTimeMillis() - start));
	}
	
	/**
	 * ��װ����
	 */
	private static void getData() {
		// ������¼ƴ�����ݵ�����
		List<Integer> index = new ArrayList<Integer>();
		// ��װ����
		if(panDuan()) {
			// ��װ��С��ʱ��
			//1����װСʱ
			sdf.append(list.get(0)).append(list.get(1));
			//2����װ
			sdf.append(":").append(list.get(2));
			if(list.get(4) > 6) {
				sdf.append(list.get(4)).append(":").append(list.get(3)).append(list.get(5));
			}else {
				sdf.append(list.get(3)).append(":").append(list.get(4)).append(list.get(5));
			}
			sdf.append(" ");
			// ��װ����ʱ��
			counter.set(0);
			while(counter.intValue() < count) {
				for(int i = list.size() - 1; i >= 0; i --) {
					Integer temp = list.get(i);
					// ƴװ��һ��
					if(!index.contains(i)) {
						if(temp <= 2 && index.size() == 0) {
							sdf.append(temp);
							index.add(i);
							counter.incrementAndGet();
							break;
						}
						// ƴװ�ڶ���
						if(temp <= 3 && index.size() == 1) {
							sdf.append(temp);
							index.add(i);
							counter.incrementAndGet();
							break;
						}
						// ƴװ������
						if(temp <= 5 && index.size() == 2) {
							sdf.append(":");
							sdf.append(temp);
							counter.incrementAndGet();
							index.add(i);
							break;
						}
						// ƴװ���ĸ�
						if(temp <= 5 && index.size() == 3) {
							sdf.append(temp);
							counter.incrementAndGet();
							index.add(i);
							break;
						}
						// ƴװ�����
						if(index.size() == 4) {
							sdf.append(":");
							sdf.append(temp);
							counter.incrementAndGet();
							index.add(i);
							break;
						}
						// ƴװ������
						if(index.size() == 5) {
							sdf.append(temp);
							counter.incrementAndGet();
							break;
						}
					}
				}
			}
			System.out.println("���Ϊ��" + sdf.toString());
		}else {
			System.out.println("���Ϊ��" + 0);
		}
	}
	
	/**
	 * ���������ж�
	 * @return
	 */
	private static boolean panDuan() {
		if(list.get(0) > 2 || list.get(1) > 3 || list.get(2) > 6 || list.get(3) > 6) {
			return false;
		}
		return true;
	}
	
	/**
	 * ��ȡ����
	 */
	private static void getNumber() {
        String num;
        // ������������
        num="123455";
        char[] charArray = num.toCharArray();
        for(char c : charArray) {
        	if(list.size() > 6) {
        		
        	}else {
        		list.add(Integer.parseInt(c + ""));
        	}
        }
//        while(counter.intValue() < count) {
//        	System.out.println("������������");
//        	if(input.hasNextInt()){
//                num=input.next();
//                Integer temp = Integer.parseInt(num);
//                if(temp < 0 || temp > 10) {
//                	System.out.println("������������0-9֮�䣺");
//                }else {
//                	counter.incrementAndGet();  
//                    list.add(temp);
//                }
//            }else {
//                num=input.next();
//                System.out.println("�������֣����������룺");
//            }
//        }
	}
	
}