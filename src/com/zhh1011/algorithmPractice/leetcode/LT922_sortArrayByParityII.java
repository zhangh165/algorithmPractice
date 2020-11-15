package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月12日 上午8:25:57
 */
public class LT922_sortArrayByParityII {
	public static int[] getResult(int[] A) {
		if(null == A || A.length <= 1) {
			return A;
		}
		int i = 0, j = 1;
		while(i < A.length && j < A.length) {
			while(i < A.length && (A[i] & 1) == 0 ) {
				i+=2;
			}
			while(j < A.length && (A[j] & 1) == 1 ) {
				j+=2;
			}
			if(i < A.length && j < A.length) {
				swap(A, i, j);
			}
		}
		return A;
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static Boolean checkAnswer(int[] A) {
		for(int i = 0; i < A.length;i++) {
			if((A[i] & 1)!=(i & 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] answer = getResult(new int[] {4,2,5,7});
		System.out.println(checkAnswer(answer)+" "+Arrays.toString(answer));
	}
}
