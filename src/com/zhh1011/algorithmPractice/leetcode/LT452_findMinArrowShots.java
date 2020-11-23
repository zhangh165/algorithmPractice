package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月23日 上午10:29:00
 */
public class LT452_findMinArrowShots {
	public static int getResult(int[][] points) {
		if(null == points || points.length == 0) {return 0;}
		else if(points.length == 1) {return 1;}
		else {
			Arrays.sort(points,(x,y)->{if(x[0]==y[0]) {return Integer.compare(x[1],y[1]);}return Integer.compare(x[0],y[0]);});
			int begin = points[0][0],last = points[0][1],count = 1;
			for(int i = 1; i < points.length;i++) {
				if(points[i][0] > last) {
					count++;
					begin = points[i][0];
					last = points[i][1];
				}else {
					last = Math.min(points[i][1],last);
					begin = Math.max(points[i][0],begin);
					System.out.println(begin+" "+last);
				}
			}
			return count;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(new int[][]{
			{-2147483646,-2147483645},
			{2147483646,2147483647}
		}));
	}
}
