package com.zhh1011.algorithmPractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.zhh1011.algorithmPractice.Util.TreeNode;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月24日 上午8:35:54
 */
public class LT222_countNodes {
	public static int getResult(TreeNode root) {
		if(null == root) {return 0;}
		Queue<TreeNode> queue = new LinkedList<>();
		int count = 0;
		queue.add(root);
		while(!queue.isEmpty()) {
			root = queue.poll();
			if(null == root) {continue;}
			queue.add(root.left);
			queue.add(root.right);
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(TreeNode.arrayToTree("1,2,3,4,5,6".split(","))));
	}
}
