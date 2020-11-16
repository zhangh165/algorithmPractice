package com.zhh1011.algorithmPractice.leetcode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月15日 下午4:28:32
 */
public class LT402_removeKdigits {
	private static int result = Integer.MAX_VALUE;
	private static Deque<Integer> stack;
	
	public static String getResult(String num, int k) {
		if(null == num || num.length() == 0 || num.length() <= k) {return "0";}
		else {
			stack =new LinkedList<>();
			dfs( k, num);
			return Integer.toString(result);
		}		
	}
	
	private static void dfs(int k,String num) {
		if(stack.size() == k) {
			result = Math.min(result, String2Integer(num));
			System.out.println(num+" "+result+" "+stack.toString());
			return;
		}else {
			for(int i = 0;i < num.length();i++) {
				if(stack.contains(i)) {
					continue;
				}
				stack.push(i);
				dfs( k, num);
				stack.poll();
			}
		}
	}
	
	private static int String2Integer(String num) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num.length();i++) {
			if(stack.contains(i)) {
				continue;
			}
			sb.append(num.charAt(i));
		}
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args) {
		System.out.print(getResult("10", 2));
	}
}
