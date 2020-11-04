package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月4日 上午8:17:16
 * 插入区间
 */
public class LT57_insert {
	public static List<int[]> getRestult(int[][] intervals, int[] newInterval){
		List<int[]> list = new ArrayList<int[]>();
		if(intervals[0][0] > newInterval[1] || intervals[intervals.length-1][1] < newInterval[0]) {}
		for(int i = 0; i < intervals.length;i++) {
			int[] temp = intervals[i];
			if(temp[0] >= newInterval[0]) {
				list.add(newInterval);
			}
			list.add(temp);
			if(temp[1] >= newInterval[0]) {
				list.add(newInterval);
			}
		}
		List<int[]> result = new ArrayList<int[]>();
		int preEnd = list.get(0)[1],preBegin = list.get(0)[0];
		for(int i = 1; i < list.size();i++) {
			int[] temp = list.get(i);
			if(preEnd  < temp[0]) {
				result.add(new int[] {preBegin,preEnd});
				preEnd = temp[1];
				preBegin = temp[0];
			}else if(preEnd >= temp[0] && preEnd < temp[1]){
				preEnd = temp[1];
			}
		}
		result.add(new int[] {preBegin,preEnd});
		return result;
	}
	
	public static void main(String[] args) {
		getRestult(new int[][] {
			{1,2},
			{3,5},
			{6,7},
			{8,10},
			{12,16}
		}, new int[] {14,18}).stream().forEach(x->System.out.print(Arrays.toString(x)));
	}
}
