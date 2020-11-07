package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;



/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月2日 上午8:20:56
 * 两个数组的交集
 */
public class LT349_intersection {
	public static int[] getResult(int[] nums1,int[] nums2) {
		int[] hash = new int[10000];
		for(int i:nums1) {
			hash[i]++;
		}

		List<Integer> list = new ArrayList<>();
		for(int i:nums2) {
			if(hash[i] >=1) {list.add(i);}
		}
		list = list.stream().distinct().collect(Collectors.toList());
		int[] result = new int[list.size()];
		for(int i = 0 ; i < result.length;i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getResult(new int[] {},new int[] {})));
	}
}
