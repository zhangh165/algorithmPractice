package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月9日 上午8:23:58
 */
public class LT973_kClosest {
	public static int[][] getResult(int[][] points, int K){
		int[][] res = new int[K][2];
        /*根据到原点的距离升序排序数组*/
        Arrays.sort(points, (o1, o2) -> (o1[0]*o1[0]+o1[1]*o1[1]) - (o2[0]*o2[0]+o2[1]*o2[1]));
        /*复制升序排序后的points数组前K项到res*/
        return Arrays.copyOf(points, K);
	}
	
	public static void main(String[] args) {
		for(int[] x:getResult(new int[][] {{1,3},{-2,2},{2,-2}}, 2)) {
			System.out.print(Arrays.toString(x));
		}
	}
}
