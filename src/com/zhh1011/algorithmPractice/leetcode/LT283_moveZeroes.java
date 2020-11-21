package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月19日 上午8:34:29
 */
public class LT283_moveZeroes {
	public static void getResult(int[] nums) {
		if(null == nums || nums.length == 0) {return;}
		int index = 0,zeroeArea = -1;
		while(index < nums.length) {
			if(nums[index] != 0) {
				zeroeArea++;
				swap(nums, index,zeroeArea);
			}else {
				index++;
			}
		}
	}
	
	private static void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,1,0,3,12};
		getResult(nums);
		System.out.println(Arrays.toString(nums));
	}
}	
