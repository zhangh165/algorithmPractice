package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;


/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月16日 上午9:00:05
 */
public class LT406_reconstructQueue {
	public static List<int[]> getResult(int[][] people) {
		List<int[]> list = new LinkedList<int[]>();
		Map<Integer,TreeSet<Integer>> map = new HashMap<>();
		for(int[] p:people) {
			if(!map.containsKey(p[0])) {
				map.put(p[0], new TreeSet<Integer>());
			}
			map.get(p[0]).add(p[1]);
		}
		TreeSet<Map.Entry<Integer, TreeSet<Integer>>> set = new TreeSet<>((x,y)->y.getKey()-x.getKey());
		set.addAll(map.entrySet());
		for(Map.Entry<Integer, TreeSet<Integer>> e:set) {
			for(Integer i:e.getValue()) {
				if(i >= list.size()) {list.add(new int[] {e.getKey(),i});}
				else {
					list.add(i, new int[] {e.getKey(),i});
				}
			}
		}
		return list;
	}
	
	private static int[][] list2Array(List<int[]> list){
		int[][] arr = new int[list.size()][];
		for(int i = 0; i < list.size();i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		getResult(new int[][] {
			{7,0},
			{4,4},
			{7,1},
			{5,0},
			{6,1},
			{5,2}
		}).stream().forEach((x)->System.out.print(Arrays.toString(x)));
	}
}
