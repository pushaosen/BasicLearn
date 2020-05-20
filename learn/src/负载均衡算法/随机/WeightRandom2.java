package 负载均衡算法.随机;

import 负载均衡算法.Server.ServerIps;

/**
 * 另外一种权重随机算法(即加权随机算法)
 * @author wb-pss576863
 *
 */
public class WeightRandom2 {

	private static String getServer() {
		
		int totalWeight = 0;
		boolean sameWeight = true;   // 如果所有权重都相等，那么随机一个IP就好了
		
		Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();
		for (int i = 0; i < weights.length; i++) {
			Integer weight = (Integer) weights[i];
			totalWeight += weight;
			if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
				sameWeight = false;
			}
		}
		
		java.util.Random random = new java.util.Random();
		int randomPos = random.nextInt(totalWeight);
		
		if (!sameWeight) {
			for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
				Integer value = ServerIps.WEIGHT_LIST.get(ip);
				if (randomPos < value) {
					return ip;
				}
				randomPos = randomPos - value;
			}
		}
		// 随机选择以一个
		return (String) ServerIps.WEIGHT_LIST.keySet().toArray()[new java.util.Random().nextInt(ServerIps.WEIGHT_LIST.size())];
	}
	
	public static void main(String[] args) {
		// 连续调用10次
		for(int i = 0; i < 10; i ++) {
			System.out.println(getServer());
		}
	}
}
