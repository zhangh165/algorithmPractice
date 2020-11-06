package com.zhh1011.algorithmPractice.leetcode;
/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月4日 下午5:08:03
 */
public class LT7_reverse {
	public static int getResult(int x) {
		boolean isNegative = x < 0;
		String str = Integer.toString(x);
		if(isNegative) {
			str = new StringBuilder(str).delete(0, 1).
					append("-").
					reverse().
					toString();
		}else {
			str = new StringBuilder(str).reverse().toString();
		}
		return Integer.valueOf(str);
	}
}
