package com.learn.com.sort;

/**
 * 模拟队列
 * @author wb-pss576863
 *
 */
public class MockQueue {
	
	private String placeOrder;
	
	private String completeOrder;

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) {
		System.out.println("接到下单请求：" + placeOrder);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.completeOrder = placeOrder;
		System.out.println("下单请求处理完毕，" + placeOrder);
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}
}
