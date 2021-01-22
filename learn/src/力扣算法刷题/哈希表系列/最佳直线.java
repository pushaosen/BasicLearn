package 力扣算法刷题.哈希表系列;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class 最佳直线 {
	
	/** 
	 * 题目：给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。
	 *     设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，则选择S[0]值较小的直线
	 *     返回，S[0]相同则选择S[1]值较小的直线返回。
	 */
	
	/** 
	 * 示例：
	 *    输入：[[0,0],[1,1],[1,0],[2,0]]
	 *    输出：[0, 2]
	 *    解释：所求直线穿过的3个点的编号为：[0,2,3]
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		最佳直线  obj = new 最佳直线();
		int[][] points = {{0,0}, {1,1}, {1,0}, {2,0}};
		int[] result = obj.bestLine(points);
		System.out.println("使用直线方程的最后的结果为：" + result.toString());
	}
	
	/** 
	 * 解法一：使用直线方程
	 */
	private HashMap<Integer, TreeSet<Integer>> map = null;
	public int[] bestLine(int[][] points) {
		map = new HashMap<>();
		// 遍历结束后，我们取set长度最大的几个，然后对比里面的节点顺序，最后返回符合题目的结果
		for(int i = 0; i < points.length; i ++) {
			for(int j = i + 1; j < points[i].length; j ++) {
				int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];

                int A = y2 - y1;
                int B = x1 - x2;
                int C = x2*y1 - x1*y2;
                
                int mcd = getMcd(getMcd(A,B),C);
                
                A /= mcd;
                B /= mcd;
                C /= mcd;
                
                int hashKey = Integer.valueOf(A+B+C+"");
                // 选入映射表
                putEle(hashKey, i, j);
			}
		}
		
		// 开始比较
		Collection<TreeSet<Integer>> values = map.values();
		int max = 0;
		TreeSet<Integer> maxSet = null;
		for(TreeSet<Integer> value : values) {
			if(value.size() > max) {
				max = value.size();
				maxSet = value;
			}else if(value.size() == max) {
				// 比较两个set的下标并排序大小   然后按题返回结果
				maxSet = compareIndex(maxSet, value);
			}
		}
		
		Object[] array = maxSet.toArray();
		int[] res = new int[2];
		for(int i = 0; i < 2; i ++) {
			res[i] = (Integer) array[i];
			System.out.println(res[i] + "\t");
		}
		return res;
	}
	private TreeSet<Integer> compareIndex(TreeSet<Integer> maxSet, TreeSet<Integer> value) {
		// 分别获取元素
		Object[] maxArray = maxSet.toArray();
		Object[] valueArray = value.toArray();
		
		// 逐次比较元素
		for(int i = 0; i < maxSet.size(); i ++) {
			if((Integer)maxArray[i] == (Integer)valueArray[i]) {
				continue;
			}
			if((Integer)maxArray[i] < (Integer)valueArray[i]) {
				return maxSet;
			}else {
				return value;
			}
		}
		return null;
	}
	private void putEle(int hashkey, int i, int j) {
		TreeSet<Integer> set = null;
		if(map.containsKey(hashkey)) {
			set = map.get(hashkey);
			set.add(i);
			set.add(j);
			map.put(hashkey, set);
		}else {
			set = new TreeSet<>();
			set.add(i);
			set.add(j);
			map.put(hashkey, set);
		}
	}
	@SuppressWarnings("unused")
	private int hash(int a, int b, int c) {
        //有符号右移   负数高位补1  正数高位补0
        return Integer.hashCode(a>>3)*Integer.hashCode(b>>4)
                *Integer.hashCode(c>>5)>>>3;
    }
	// 获取最大公约数
	private int getMcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		// 默认a是最大值，b是最小值   a = 被除数   b=除数
		int remain = a % b;
		if(remain == 0) {
			return b;
		}else {
			// 如果a>b=>a%b较小值  如果 a<b => a%b=a  所以这里不需要判断谁大谁小
			// 因为如果a大于b那么计算是正常   如果a<b下一轮传入的参数位置就互换位置了，就是b/a了
			// 这里如果写成getMcd(remain,b); 就有可能造成死循环了  因为如果a<b，那么这里的参数一直是 a，b了
			return getMcd(b, remain);
		}
	}
	

}
