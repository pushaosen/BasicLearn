package com.learn.com.sort;

import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
		String str = "100110010100001101";
		// ������ʽ����֤�ַ����Ƿ�ȫ������
		Pattern pattern = Pattern.compile("\\d+");
		// ��¼���ֵĴ���
		int count = 0;
		// ����0�������ֵĴ���
		int position1 = 1;
		// ����1�������ֵĴ���
		int position2 = 1;
		// �������ȫ�����ֵĻ������������ı���������ֵĴ���
        if(pattern.matcher(str).matches()) {
        	int len = str.length();
        	// ��һ��ѭ������ȡ�Ƚϵ����������
        	for(int i = 0; i < len;) {
        		// ���i==len - 1����ʾ���һ�����֣��Ͳ���Ҫ��������ѭ����
        		if(i == len -1) {
        			// ��ӡ���
        			if(str.charAt(i) == '0') {
        				System.out.println(str.charAt(i) + "�������ֵ�" + position1 + "�εĸ���Ϊ��" + (++ count));
        			}else {
        				System.out.println(str.charAt(i) + "�������ֵ�" + position2 + "�εĸ���Ϊ��" + (++ count));
        			}
        			// �������ѭ��
        			break;
            	}
        		// �ڲ�ѭ��
        		for(int j = i; j < len; j ++) {
        			// ���������ݵ����ڲ����ݣ����������1
        			if(str.charAt(i) == str.charAt(j)) {
        				count ++;
        			}else {
        				// ���򣬾ͽ������
        				if(str.charAt(i) == '0') {
        					System.out.println(str.charAt(i) + "�������ֵ�" + (position1 ++) + "�εĸ���Ϊ��" + (count ++));
            			}else {
            				System.out.println(str.charAt(i) + "�������ֵ�" + (position2 ++) + "�εĸ���Ϊ��" + (count ++));
            			}
        				// ����������0�������´μ���
        				count = 0;
        				// ������������ڲ��������ӿ�����ѭ������������������ֵıȽ�
        				i = j;
        				// �����ڲ�ѭ��
        				break;
        			}
        		}
        	}
        }
	}
}