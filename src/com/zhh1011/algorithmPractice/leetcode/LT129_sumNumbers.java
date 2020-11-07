package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.zhh1011.algorithmPractice.Util.TreeNode;

/**
 * author: dsa44
 * create time: 2020/10/29 13:24
 */
public class LT129_sumNumbers {
	public static int sum = 0;
	public static int getResult(TreeNode root) {
		if(root == null) {return 0;}
		Deque<Integer> stack = new LinkedList<>();
		dfs(stack, root);
		return sum;
	}
	
	private static void dfs(Deque<Integer> stack,TreeNode root) {
		if(root == null) {return;}
		stack.push(root.val);
		if(root.left == null && root.right == null) {
			sum+=stack2Integer(stack);
			return;
		}
		dfs(stack, root.left);
		dfs(stack, root.right);
		stack.poll();
	}
	
	private static Integer stack2Integer(Deque<Integer> stack) {
		if(stack.size() == 0) {return 0;}
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>(stack);
		for(Integer i:list) {
			sb.append(i);
		}
		stack.poll();
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.arrayToTree("1,2,3".split(","));
		System.out.println(getResult(root));
	}
}
