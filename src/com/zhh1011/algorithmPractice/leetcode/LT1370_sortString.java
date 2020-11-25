package com.zhh1011.algorithmPractice.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月25日 上午8:21:57
 */
public class LT1370_sortString {
	public static String sortString(String s) {
		Map<Character,Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length();i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),0);
			}
			map.put(s.charAt(i),map.get(s.charAt(i))+1);
		}
		TreeSet<Map.Entry<Character,Integer>> set = new TreeSet<>((x,y)->{return x.getKey()-y.getKey();});
		set.addAll(map.entrySet());
		Iterator<Map.Entry<Character,Integer>> iterator = null;
		Iterator<Map.Entry<Character,Integer>> iterator0 = null;
		while(!set.isEmpty()&&sb.length()<s.length()) {
			iterator = set.iterator();
			while(iterator.hasNext()) {
				Map.Entry<Character, Integer> entry = iterator.next();
				if(entry.getValue() <= 0) {
					iterator.remove();
					continue;
				}
				sb.append(entry.getKey());
				entry.setValue(entry.getValue()-1);
			}
			iterator0 = set.descendingIterator();
			while(iterator0.hasNext()) {
				Map.Entry<Character, Integer> entry = iterator0.next();
				if(entry.getValue() <= 0) {
					iterator0.remove();
					continue;
				}
				sb.append(entry.getKey());
				entry.setValue(entry.getValue()-1);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(sortString("aaaabbbbcccc"));
	}
}
