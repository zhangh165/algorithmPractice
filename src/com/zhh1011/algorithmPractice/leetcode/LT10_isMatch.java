package com.zhh1011.algorithmPractice.leetcode;
/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月25日 下午5:59:31
 */
public class LT10_isMatch {
	public static boolean getResult(String s,String p) {
		if(null == s || s.length() == 0) {
			return p.length() == 0;
		}
		int index = 0,pIndex = 0;
		while(index < s.length()&&index!=-1) {
			index = helper(s, p, index,pIndex++);
		}
		return index != -1; 
	}
	
	private static int helper(String s,String p, int index,int pIndex) {
		if(index >= s.length()) {return index;}
		if(pIndex >= p.length()) {return -1;}
		switch (p.charAt(pIndex)) {
		case '.':
			return index+1;
		case '*':
			if(pIndex == 0) {return index;}
			char charTemp = p.charAt(pIndex-1);
			if(charTemp == '.') {return pIndex == p.length() -1?s.length():-1;}
			while(index < s.length()) {
				if(charTemp == s.charAt(index)) {index++;}
				else {break;}
			}
			return index;
			
		default:
			if(s.charAt(index) == p.charAt(pIndex)) {
				return index+1;
			}else {
				if(pIndex+1 < p.length() && p.charAt(pIndex+1) == '*') {
					return index;
				}
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getResult("aab", "c*a*b"));
	}
}
