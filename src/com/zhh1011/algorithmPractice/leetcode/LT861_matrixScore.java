package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年12月7日 上午9:30:25
 */
public class LT861_matrixScore {
	public static int getResult(int[][] A) {
		if(null == A || A.length == 0) {
			return 0;
		}
		int[] zeroCount = new int[A[0].length];
		for(int i = 0; i < A.length;i++) {
			if(A[i][0] != 1) {
				A[i]= Arrays.stream(A[i]).map(x->{return x==0?1:0;}).toArray();
			}
			for(int j = 0; j < A[0].length;j++) {
				if(A[i][j] == 0) {
					zeroCount[j]++;
				}
			}
		}
		int result = 0;
		for(int i = 0; i < zeroCount.length;i++) {
			if(zeroCount[i]*2 > A.length) {
				for(int j = 0 ; j < A.length;j++) {
					A[j][i]=A[j][i] == 0?1:0;
				}
			}
		}
		for(int i = 0; i < A.length;i++) {
			result+=binary2Int(A[i]);
		}
		return result;
	}
	
	private static int binary2Int(int[] binary) {
		int result = 0;
		for(int i = binary.length-1;i >=0 ;i--) {
			result+=(Math.pow(2,i)*binary[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(new int[][] {
			{0,0,1,1},
			{1,0,1,0},
			{1,1,0,0}
		}));
	}
}
