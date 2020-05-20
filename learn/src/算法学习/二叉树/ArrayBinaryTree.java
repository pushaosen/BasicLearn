package 算法学习.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用数组构建二叉树
 * @author lenovo
 *
 */
public class ArrayBinaryTree {
	
	private int[] arr;
	
	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	/**
	 * 前序遍历
	 * @param index
	 */
	public void preOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，不可以按照二叉树的前序遍历");
		}
		System.out.println(arr[index]);
		// 向左进行前序遍历
		if(index * 2 + 1 < arr.length) {  // 防止数组下标越界
			preOrder(2 * index + 1);
		}
		// 向右递归
		if(index * 2 + 2 < arr.length) {
			preOrder(2 * index + 2);
		}
	}
	
	/**
	 * 中序遍历
	 * @param index
	 */
	public void infixOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，不可以按照二叉树来进行遍历");
		}
		// 向左遍历
		if(2 * index + 1 < arr.length) {
			infixOrder(2 * index + 1);
		}
		System.out.println(arr[index]);
		// 向右遍历
		if(2 * index + 2 < arr.length) {
			infixOrder(2 * index + 2);
		}
	}
	
	/**
	 * 后序遍历
	 */
	public void postOrder(int index) {
		if(arr==null||arr.length==0)
		{
			System.out.println("数组为空，不可以按照二叉树来进行遍历~");
		}
		if(2*index+1<arr.length)
		{
			infixOrder(2*index+1);
		}
		System.out.println(arr[index]);
		if(2*index+2<arr.length)
		{
			infixOrder(2*index+2);
		}
		System.out.println(arr[index]);
	}
	
	public static void main(String[] args) {
//		int[] arr= {1,2,3,4,5,6,7,};
//		ArrayBinaryTree arrBinaryTree=new ArrayBinaryTree(arr);
//		arrBinaryTree.preOrder(0);
//		arrBinaryTree.infixOrder(0);
//		arrBinaryTree.postOrder(0);
		
		List<String> list = new ArrayList<>();
		list.add("李四");
		list.add("");
		list.add("张三");
		list.stream().forEach(str -> {
			if(str == null || "".equals(str)) {
				return;
			}
			System.out.println("进来了");
			System.out.println(str);
		});
		
	}

}
