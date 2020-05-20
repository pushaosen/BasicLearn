package �㷨ѧϰ.������;

import java.util.ArrayList;
import java.util.List;

/**
 * ʹ�����鹹��������
 * @author lenovo
 *
 */
public class ArrayBinaryTree {
	
	private int[] arr;
	
	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	/**
	 * ǰ�����
	 * @param index
	 */
	public void preOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ������԰��ն�������ǰ�����");
		}
		System.out.println(arr[index]);
		// �������ǰ�����
		if(index * 2 + 1 < arr.length) {  // ��ֹ�����±�Խ��
			preOrder(2 * index + 1);
		}
		// ���ҵݹ�
		if(index * 2 + 2 < arr.length) {
			preOrder(2 * index + 2);
		}
	}
	
	/**
	 * �������
	 * @param index
	 */
	public void infixOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ������԰��ն����������б���");
		}
		// �������
		if(2 * index + 1 < arr.length) {
			infixOrder(2 * index + 1);
		}
		System.out.println(arr[index]);
		// ���ұ���
		if(2 * index + 2 < arr.length) {
			infixOrder(2 * index + 2);
		}
	}
	
	/**
	 * �������
	 */
	public void postOrder(int index) {
		if(arr==null||arr.length==0)
		{
			System.out.println("����Ϊ�գ������԰��ն����������б���~");
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
		list.add("����");
		list.add("");
		list.add("����");
		list.stream().forEach(str -> {
			if(str == null || "".equals(str)) {
				return;
			}
			System.out.println("������");
			System.out.println(str);
		});
		
	}

}
