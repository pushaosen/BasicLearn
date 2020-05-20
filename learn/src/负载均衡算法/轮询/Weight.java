package 负载均衡算法.轮询;

public class Weight {
	
	private Integer currentWeight;  // 动态的权重
	private Integer weight;   // 固定的权重
	private String ip;   // ip地址
	public Weight(Integer currentWeight, Integer weight, String ip) {
		super();
		this.currentWeight = currentWeight;
		this.weight = weight;
		this.ip = ip;
	}
	public Integer getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(Integer currentWeight) {
		this.currentWeight = currentWeight;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
