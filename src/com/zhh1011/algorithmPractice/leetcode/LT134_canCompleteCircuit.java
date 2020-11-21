package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月18日 上午8:44:12
 */
public class LT134_canCompleteCircuit {
	public static int getResult(int[] gas, int[] cost) {
		if(null == gas || gas.length == 0 || gas.length != cost.length) {return -1;}
		int[] mark = new int[gas.length];
		for(int i = 0; i < gas.length;i++) {
			mark[i] = gas[i]-cost[i];
		}
		int temp = Arrays.stream(mark).sum();
		if(temp < 0) {return -1;}
		else {
			for(int i = 0; i < mark.length;i++) {
				if(mark[i] < 0) {continue;}
				else if(cheackIsCompleteCircuit(mark, i)) {return i;}
			}
			return -1;
		}
	}
	
	private static boolean cheackIsCompleteCircuit(int[] arr,int index) {
		int i = index+1 == arr.length?0:index+1,sum = arr[index];
		while( i!= index) {
			sum+=arr[i];
			if(sum < 0) {return false;}
			i = i+1 == arr.length?0:i+1;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(new int[] {5,1,2,3,4}, new int[] {4,4,1,5,1}));
	}
}
