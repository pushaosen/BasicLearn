package com.learn.com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * ��������ˮ������3��worker: worker1��worker2��worker3,ֻ�е�worker1��worker2ִ����ʱ�ſ���ִ��worker3
 * @author wb-pss576863
 *
 */
public class CountDownLatchResult {

	public static void main(String[] args) throws InterruptedException {
		int COUNT = 2;
		final CountDownLatch countDownLatch = new CountDownLatch(COUNT);
		WorkerCount worker0 = new WorkerCount("lilei-0", (long)(Math.random() * 10000), countDownLatch);
        WorkerCount worker1 = new WorkerCount("lilei-1", (long)(Math.random() * 10000), countDownLatch);
        worker0.start();
        worker1.start();
        countDownLatch.await();
        System.out.println("׼����������");
        
        WorkerCount worker2 = new WorkerCount("lilei-2", (long)(Math.random() * 10000), countDownLatch);
        worker2.start();
        Thread.sleep(1000);
        
        System.out.println(new BigDecimal(100).multiply(new BigDecimal(100)).divide(new BigDecimal(1),
                2, BigDecimal.ROUND_HALF_UP));
        List<String> list = new ArrayList<>();
        list.add("jjj");
        System.out.println(list.isEmpty() || (list.contains("jj")));
        
        System.out.println("pcc_order_UNKNOW".substring(1,"pcc_order_UNKNOW".lastIndexOf("_")));
        System.out.println("-".length());
        
        String [] tableNmaes = new String[]{"", ""};
        tableNmaes = "-UNKNOW".split("-");
        
        System.out.println("wei:" + tableNmaes[0]);
        System.out.println("Ϊ��" + tableNmaes[1]);
        
        Integer a = 300;
        Integer b = 300;
        System.out.print("���Ϊ��"  + (a == b));
        
	}
}
