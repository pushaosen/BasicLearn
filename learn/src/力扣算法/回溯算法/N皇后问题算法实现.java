package 力扣算法.回溯算法;

import java.util.Vector;

/*
 * 这个问题很简单了，简单解释一下：给你一个N*N的棋盘，让你放置N各皇后，使得它们不能相互攻击。
 * 
 * PS：皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 * 
 * 这个问题本质上跟全排列问题差不多，决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
 */
public class N皇后问题算法实现 {

	Vector<Vector<String>> res;
	
	// 输入棋盘边长n，返回所有合法的位置
	Vector<Vector<String>> solveNQueens(int n){
		// '.'表示空,'Q'表示皇后，初始化空棋盘
//		Vector<String> board(n, String(n, '.'));
		return res;
	}
}
