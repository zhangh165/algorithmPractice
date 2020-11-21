package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月17日 上午8:42:44
 */
public class LT1030_allCellsDistOrder {
	public static int[][] getResult(int R, int C, int r0, int c0) {
		List<int[]> set = new ArrayList<>();
		int[][] result = new int[R*C][];
		for(int i = 0; i < R;i++) {
			for(int j = 0; j < C;j++) {
				set.add(new int[] {i,j});
			}
		}
		set.sort((x,y)->{return (Math.abs(x[0]-r0)+Math.abs(x[1]-c0))-(Math.abs(y[0]-r0)+Math.abs(y[1]-c0));});
		for(int i = 0; i < R*C;i++) {
			result[i] = set.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Arrays.stream(getResult(2, 2, 0, 1)).forEach(x->System.out.print(Arrays.toString(x)));
	}
}
