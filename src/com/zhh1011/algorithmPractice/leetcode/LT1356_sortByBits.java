package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月6日 上午8:21:34
 */
public class LT1356_sortByBits {
	public static int[] getResult(int[] arr) {
		return Arrays.stream(arr).boxed().sorted((x,y)->{return Integer.bitCount(x)==Integer.bitCount(y)?x-y:Integer.bitCount(x)-Integer.bitCount(y);}).mapToInt(Integer::valueOf).toArray();
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getResult(new int[] {1024,512,256,128,64,32,16,8,4,2,1})));
	}
}
