package 负载均衡算法.随机;

import java.util.ArrayList;
import java.util.List;

import 负载均衡算法.Server.ServerIps;

/**
 * 权重随机算法(即加权随机算法)
 * @author wb-pss576863
 *
 */
public class WeightRandom {

	private static String getServer() {
		// 生成一个随机数作为list的下标值
		List<String> ips = new ArrayList<>();
		
		for(String ip : ServerIps.WEIGHT_LIST.keySet()) {
			Integer weight = ServerIps.WEIGHT_LIST.get(ip);
			
			// 按权重进行复制
			for(int i = 0; i < weight; i ++) {
				ips.add(ip);
			}
		}
		
		java.util.Random random = new java.util.Random();
		int randomPos = random.nextInt(ips.size());
		return ips.get(randomPos);
	}
	
	public static void main(String[] args) {
		// 连续调用10次
		for(int i = 0; i < 10; i ++) {
			System.out.println(getServer());
		}
	}
}
