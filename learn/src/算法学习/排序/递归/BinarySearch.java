package 算法学习.排序.递归;

/**
 * 二分查找汇总类：前提是数组已经有序
 * 
 * 递归的定义：1、边界条件
 * 		   2、递归前进段
 *         3、递归返回段
 * @author lenovo
 *
 */
public class BinarySearch {
	
	/**
	 * 不用递归的二分查找：就使用普通的循环查找(时间复杂度为：O(logN))
	 * @param array   已经排好序的数组
	 * @param key     需要查找的值key
	 * @return
	 */
	public static int findTwoPoint(int[] array, int key) {
		int start = 0;
		int last = array.length;
		while(start <= last) {   // 使用循环代替递归
			int mid = (last - start) / 2 + start;   // 初始数组的中间值
			if(key == array[mid]) {        // 查找值与当前值一样大
				return mid;
			}else if(key > array[mid]) {   // 查找值比当前值大
				start = mid + 1;
			}else if(key < array[mid]) {   // 查找值比当前值小
				last = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * 使用递归进行二分查找：时间复杂度为：O(logN)   该递归调用也是一个典型的分治算法的例子
	 * @param array   数组
	 * @param key     需要查找到值
	 * @param low     数组坐标的最小值
	 * @param high    数组坐标的最大值
	 * @return
	 */
	public static int search(int[] array, int key, int low, int high) {
		int mid = (high - low) / 2 + low;
		if(key == array[mid]) {   // 查找值与当前值相等
			return mid;
		}else if(low > high) {    // 找不到查找值，返回-1
 			return -1;
		}else {
			if(key < array[mid]) {    // 查找值比当前值小
				return search(array, key, low, high - 1);    // 递归调用
			}else if(key > array[mid]) {  // 查找值比当前值大
				return search(array, key, low + 1, high);    // 递归调用
			}
		}
		return -1;
	}
	
	/**
	 * 汉诺塔问题
	 * @param dish    盘子个数(也表示名称)
	 * @param from    初始塔座
	 * @param temp    中介塔座
	 * @param to      目标塔座
	 */
	public static void move(int dish, String from, String temp, String to) {
		if(dish == 1) {
			System.out.println("将盘子"+dish+"从塔座"+from+"移动到目标塔座"+to);
		}else {
			move(dish-1,from,to,temp);//A为初始塔座，B为目标塔座，C为中介塔座
	        System.out.println("将盘子"+dish+"从塔座"+from+"移动到目标塔座"+to);
	        move(dish-1,temp,from,to);//B为初始塔座，C为目标塔座，A为中介塔座
		}
	}
	
	public static void main(String[] args) {
		// 测试汉诺塔问题
		move(3,"A","B","C");
	}

}
