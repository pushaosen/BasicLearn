package ���ؾ����㷨.��ѯ;

public class Weight {
	
	private Integer currentWeight;  // ��̬��Ȩ��
	private Integer weight;   // �̶���Ȩ��
	private String ip;   // ip��ַ
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
