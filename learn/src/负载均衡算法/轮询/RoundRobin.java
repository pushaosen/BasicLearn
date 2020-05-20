package 负载均衡算法.轮询;

import 负载均衡算法.Server.ServerIps;

public class RoundRobin {
	// 当前循环的位置
	private static Integer pos = 0;
	
	public static String getServer() {
		String ip = null;
		// pos
		synchronized (pos) {
			if (pos >= ServerIps.LIST.size()) {
				pos = 0;
			}
			ip = ServerIps.LIST.get(pos);
			pos++;
		}
		return ip;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			System.out.println(getServer());
		}
	}

}
