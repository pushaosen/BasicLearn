package com.learn.com;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * ��������ˮ������3��worker: worker1��worker2��worker3,ֻ�е�worker1��worker2ִ����ʱ�ſ���ִ��worker3
 * joinҲ�������
 * @author wb-pss576863
 *
 */
public class JoinResult {

	public static void main(String[] args) throws InterruptedException {
		Worker worker0 = new Worker("lilei-0", (long)(Math.random() * 10000));
        Worker worker1 = new Worker("lilei-1", (long)(Math.random() * 10000));
        Worker worker2 = new Worker("lilei-2", (long)(Math.random() * 10000));
        worker0.start();
        worker1.start();
        
        worker0.join();
        worker1.join();
        
        System.out.println("׼����������");
        
        worker2.start();
        Thread.sleep(1000);
        
        System.out.println("���ȴ�ʱ�䣺" + BigDecimal.ZERO);
        System.out.println(new BigDecimal(100).divide(new BigDecimal(10), 0,
                BigDecimal.ROUND_UP));
        System.out.println(new BigDecimal(10000).divide(new BigDecimal(10000),
                4));
        int hash = Objects.hash("str", "jay");
        System.out.println(Objects.hash("str", "jay"));
        System.out.println(hash);
        
        int a = 27, b = 40;
        System.out.println("���Ϊ��" + ((float)a/(float)b));
        
	}
}
