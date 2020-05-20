package 负载均衡算法.轮询;

import java.util.HashMap;
import java.util.Map;

import 负载均衡算法.Server.ServerIps;

/**
 * 加权平滑轮询
 * @author wb-pss576863
 *
 */
public class RoundRobinV3 {
	
	private static Map<String, Weight> weightMap = new HashMap<>();
	
	public static String getServer() {
		
		// 获取权重之和
		int totalWeight = ServerIps.WEIGHT_LIST.values().stream().reduce(0, (w1, w2) -> (w1+w2));
		
		// 初始化
		if(weightMap.isEmpty()) {
			for(String ip : ServerIps.WEIGHT_LIST.keySet()) {
				Integer weight = ServerIps.WEIGHT_LIST.get(ip);
				weightMap.put(ip, new Weight(weight, weight, ip));
			}
		}
		
		// 获取最大的weight
		Weight maxWeight = null;
		for(Weight weight : weightMap.values()) {
			if(maxWeight == null || weight.getCurrentWeight() > maxWeight.getCurrentWeight()) {
				maxWeight = weight;
			}
		}
		
		// 将maxWeight-总权重和
		maxWeight.setCurrentWeight(maxWeight.getCurrentWeight() -totalWeight);
		
		// 将所有的加上自己固定的权重
		for (Weight weight : weightMap.values()) {
			weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
		}
		
		return maxWeight.getIp();
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i ++) {
			System.out.println(getServer());;
		}
	}
}
