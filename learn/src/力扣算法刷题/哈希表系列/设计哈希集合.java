package 力扣算法刷题.哈希表系列;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class 设计哈希集合 {
	
	/** 
	 * 题目：不使用任何内建的哈希表库设计一个哈希集合
	 *     具体地说，你的设计应该包含以下的功能：
	 *            1、add(value)：向哈希集合中插入一个值。
	 *            2、contains(value) ：返回哈希集合中是否存在这个值。
	 *            3、remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
	 */
	
	/** 
	 * 示例：
	 *    MyHashSet hashSet = new MyHashSet();
			hashSet.add(1);         
			hashSet.add(2);         
			hashSet.contains(1);    // 返回 true
			hashSet.contains(3);    // 返回 false (未找到)
			hashSet.add(2);          
			hashSet.contains(2);    // 返回 true
			hashSet.remove(2);          
			hashSet.contains(2);    // 返回  false (已经被删除)
	 */
	
	/** 
	 * 解法一：单独链表法（及使用链表作为桶）
	 * 时间复杂度：查询的时候需要遍历整个桶，故时间复杂度为O(N)
	 */
	private int keyRange = 769;
	private Bucket[] bucketArray = new Bucket[this.keyRange];
	private void init() {
		for (int i = 0; i < this.keyRange; ++i) {
			this.bucketArray[i] = new Bucket();
		}
	}
	// 一个简单的hash函数
	private int _hash(int key) {
		return (key % this.keyRange);
	}
	// 添加元素
	private void add(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].insert(key);
	}
	// 删除元素
	private void remove(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].delete(key);
	}
	// 判断一个元素是否存在
	private boolean contains(int key) {
		int bucketIndex = this._hash(key);
		return this.bucketArray[bucketIndex].exists(key);
	}
	// 以链表作为桶
	class Bucket{
		private LinkedList<Integer> container;
		public Bucket() {
			this.container = new LinkedList<>();
		}
		// 插入元素
		public void insert(Integer key) {
			int index = this.container.indexOf(key);
			if(index == -1) {
				this.container.addFirst(key);
			}
		}
		// 删除元素
		public void delete(Integer key) {
			this.container.remove(key);
		}
		// 判断元素是否存在
		public boolean exists(Integer key) {
			int index = this.container.indexOf(key);
			return index != -1;
		}
	}
	
	/** 
	 * 解法二：使用二叉搜索树作为桶
	 * 不同点：与解法一的不同点在于桶的数据结构不一样，解法一的数据结构为链表，解法二的数据结构为树
	 * 时间复杂度：查询元素的时候，不需要遍历整个桶，采用二分法的方式，查询的时间复杂度为O(logN)
	 */
	// 以树作为桶
	class Bucket1{
		private BSTree tree;
		public Bucket1() {
			tree = new BSTree();
		}
		public void insert(Integer key) {
			this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
		}
		public void delete(Integer key) {
			this.tree.root = this.tree.deleteNode(this.tree.root, key);
		}
		public boolean exists(Integer key) {
			TreeNode node = this.tree.searchBST(this.tree.root, key);
			return node != null;
		}
	}
	// 创建节点类
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	// 构造树
	class BSTree {
		TreeNode root = null;
		// 查找
		public TreeNode searchBST(TreeNode root, int val) {
			if(root == null || val == root.val) {
				return root;
			}
			return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
		}
		// 插入
		public TreeNode insertIntoBST(TreeNode root, int val) {
			if(root == null) {
				return new TreeNode(val);
			}
			if(val > root.val) {
				root.right = insertIntoBST(root.right, val);
			}else if(val == root.val) {
				return root;
			}else {
				root.left = insertIntoBST(root.left, val);
			}
			return root;
		}
		// 一直向左遍历
		public int successor(TreeNode root) {
			root = root.right;
			while(root.left != null) {
				root = root.left;
			}
			return root.val;
		}
		// 一直向右遍历
		public int predecessor(TreeNode root) {
			root = root.left;
			while(root.right != null) {
				root = root.right;
			}
			return root.val;
		}
		// 删除某个节点
		public TreeNode deleteNode(TreeNode root, int key) {
			if(root == null) {
				return null;
			}
			if(key > root.val) {
				root.right = deleteNode(root.right, key);
			}else if(key < root.val) {
				root.left = deleteNode(root.left, key);
			}else {
				if(root.left == null && root.right == null) {
					root = null;
				}else if(root.right != null) {
					root.val = successor(root);
					root.right = deleteNode(root.right, root.val);
				}else {
					root.val = predecessor(root);
					root.left = deleteNode(root.left, root.val);
				}
			}
			return root;
		}
	}
}
