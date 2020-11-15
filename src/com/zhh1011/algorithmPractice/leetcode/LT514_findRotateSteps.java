package com.zhh1011.algorithmPractice.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月11日 上午8:30:08
 * 存在问题：不是最优解
 */
public class LT514_findRotateSteps {
	public static int getResult(String ring,String key) {
		int index = 0,result = 0;
		for(char c:key.toCharArray()) {
			int curKeyCharIndex = matchChar(ring, index, c);
			int length = Math.abs(index - curKeyCharIndex);
			result+=Math.min(length, ring.length()-length)+1;
			index = curKeyCharIndex;
		}
		return result;
	}
	
	private static int matchChar(String ring,int index,char target) {
		if(ring.charAt(index) == target) {return index;}
		int left = index -1 < 0?ring.length()-1:index-1,
				right = index+1 >= ring.length()?0:index+1;
		while(true) {
			if(ring.charAt(left) ==target) {
				break;
			}
			left = left -1 < 0?ring.length()-1:left-1;
			if(ring.charAt(right) ==target) {
				break;
			}
			right = right+1 >= ring.length()?0:right+1;
		}
		return ring.charAt(left) ==target?left:right;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s1 = reader.readLine();
		s1 = s1.substring(1,s1.length()-1);
		String s2 = reader.readLine();
		s2 = s2.substring(1,s2.length()-1);
		System.out.println(s1+" "+s2);
		System.out.println(getResult(s1, s2));
	}
}
