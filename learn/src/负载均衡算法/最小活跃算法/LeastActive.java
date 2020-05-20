package 负载均衡算法.最小活跃算法;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import 负载均衡算法.Server.ServerIps;

/**
 * 最小活跃数算法
 * @author wb-pss576863
 *
 */
public class LeastActive {
	
	private static String getServer() {
		// 找出当前活跃数最小的服务器
		Optional<Integer> minValue = ServerIps.ACTIVITY_LIST.values().stream().min(Comparator.naturalOrder());
		
		if (minValue.isPresent()) {
			List<String> minActivityIps = new ArrayList<>();
			ServerIps.ACTIVITY_LIST.forEach((ip, activity) -> {
				if (activity.equals(minValue.get())) {
					minActivityIps.add(ip);
				}
			});
		
			// 权重逻辑：最小活跃数的ip有多个，则根据权重来选，权重大的优先
			if (minActivityIps.size() > 1) {
				// 过滤出对应的ip和权重
				Map<String, Integer> weightList = new LinkedHashMap<String, Integer>();
				ServerIps.WEIGHT_LIST.forEach((ip, weight) -> {
					if (minActivityIps.contains(ip)) {
						weightList.put(ip, ServerIps.WEIGHT_LIST.get(ip));
					}
				});
				
				int totalWeight = 0;
				boolean sameWeight = true;   // 如果所有权重都相等，那么随机一个IP就好了
				
				Object[] weights = weightList.values().toArray();
				
				if(weightList.size() > 0) {
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
						for (String ip : weightList.keySet()) {
							Integer value = weightList.get(ip);
							if (randomPos < value) {
								return ip;
							}
							randomPos = randomPos - value;
						}
					}
					return (String) weightList.keySet().toArray()[new java.util.Random().nextInt(weightList.size())];
				}else {
					return null;
				}
			} else {
				return minActivityIps.get(0);
			}
		} else {
			return (String) ServerIps.WEIGHT_LIST.keySet().toArray()[new java.util.Random().nextInt(ServerIps.WEIGHT_LIST.size())];
		}
	}
	
	public static void main(String[] args) {
		// 连续调用10次，随机10个client
		for (int i = 0; i < 10; i++) {
			System.out.println(getServer());
		}
	}
}
