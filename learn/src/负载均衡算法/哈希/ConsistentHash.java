package ���ؾ����㷨.��ϣ;

import java.util.SortedMap;
import java.util.TreeMap;

import ���ؾ����㷨.Server.ServerIps;

/**
 * һ���Թ�ϣ�㷨
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
	
	// ��ȡip��ַ
	private static String getServer(String client) {
		int hash = getHash(client);
		// �Ҵ���hash��һ������ڵ�(��һ������,��һ���ź����Map)
		SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
		
		// ��ȡ���ڸ�hash�ĵ�һ��Ԫ�ص�ֵ
		Integer nodeIndex = subMap.firstKey();
		
		if(null == nodeIndex) {
			nodeIndex = virtualNodes.firstKey();
		}
		
		// ���ض�Ӧ������������
		return subMap.get(nodeIndex);
	}
	
	// hash����
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
		// ����������ֵ�Ǹ�����ȡ����ֵ
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
