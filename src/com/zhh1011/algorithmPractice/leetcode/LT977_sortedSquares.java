package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * author: dsa44
 * create time: 2020/10/16 9:01
 * 很简单得一道题，没什么难度...
 */
public class LT977_sortedSquares {
    public static int[] getResult(int[] A) {
        return Arrays.stream(A).map(x->x*x).sorted().toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getResult(new int[]{})));
    }
}