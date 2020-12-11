package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年12月1日 上午8:32:11
 */
public class LT34_searchRange {
	public static int[] getResult(int[] nums,int target) {
		if(null == nums || nums.length == 0) {
			return new int[] {-1,-1};
		}else if(nums.length == 1){
			return nums[0] == target?new int[] {0,0}:new int[] {-1,-1};
		}else {
			int i = 0, j = nums.length-1,mid = 0;
			int[] result = new int[] {-1,-1};
			while(i <= j) { mid = i+(j-i)/2;
				if(nums[mid] >target) {
					j = mid - 1;
				}else if(nums[mid] < target){
					i = mid + 1;
				}else {
					result[0] = mid;
					break;
				}
			}
			i = mid;
			j = nums.length-1;
			while(i <= j) {
				mid = i+(j-i)/2;
				if(nums[mid] <target) {
					i = mid+1;
				}else if(nums[mid] > target){
					j = mid-1;
				}else {
					result[1] = mid;
					break;
				}
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getResult(new int[] {5,7,7,8,8,10},8)));
	}
}
