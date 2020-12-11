package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年12月11日 下午3:04:32
 */
public class LT649_predictPartyVictory {
	public static String getResult(String senate) {
		if(null == senate || senate.length() == 0) {
			return null;
		}else if(senate.length()==1 && senate.indexOf(""+'R') != -1 && senate.indexOf(""+'D') != -1){
			return senate.charAt(0) =='R'?"Radiant":"Dire";
		}else {
			List<Character> list = new LinkedList<>();
			for(char c: senate.toCharArray()) {
				list.add(c);
			}
			int r = 0, d =0 ;
			Iterator<Character> iterator = list.iterator();
			while(list.size() > 1 && list.contains('R') && list.contains('D')) {
				iterator = list.iterator();
				while(iterator.hasNext()) {
					switch (iterator.next()) {
						case 'R':
							if(r > 0) {
								r--;
								iterator.remove();
							}else {
								d++;
							}
							break;
						case 'D':
							if(d > 0) {
								d--;
								iterator.remove();
							}else {
								r++;
							}
							break;
						default:
							break;
					}
				}
			}
			return list.get(0).charValue()=='R'?"Radiant":"Dire";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getResult("RRRDDDDDD"));
	}
}
