package 负载均衡算法.哈希;

import java.util.SortedMap;
import java.util.TreeMap;

import 负载均衡算法.Server.ServerIps;

/**
 * 一致性哈希算法
 * @author wb-pss576863
 *
 */
public class ConsistentHash {
	private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();
	private static final int VIRTUAL_NODES = 160;
	
	static {
		for (String ip : ServerIps.LIST) {
			for (int i = 0; i < VIRTUAL_NODES; i++) {
				int hash = getHash(ip+"VN"+i);
				virtualNodes.put(hash, ip);
			}
		}
	}
	
	// 获取ip地址
	private static String getServer(String client) {
		int hash = getHash(client);
		// 找大于hash的一个虚拟节点(即一个子树,即一个排好序的Map)
		SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
		
		// 获取大于该hash的第一个元素的值
		Integer nodeIndex = subMap.firstKey();
		
		if(null == nodeIndex) {
			nodeIndex = virtualNodes.firstKey();
		}
		
		// 返回对应虚拟机点的名称
		return subMap.get(nodeIndex);
	}
	
	// hash函数
	private static int getHash(String str) {
		final int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < str.length(); i++)
		hash = (hash ^ str.charAt(i)) * p;
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;
		// 如果算出来的值是负数则取绝对值
		if (hash < 0)
			hash = Math.abs(hash);
			return hash;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getServer("client" + i));
		}
	}
}
