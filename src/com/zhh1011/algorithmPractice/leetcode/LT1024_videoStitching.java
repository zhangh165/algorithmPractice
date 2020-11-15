package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author: dsa44
 * create time: 2020/10/24 10:10
 * TODO : 贪心 重写
 */
public class LT1024_videoStitching {
    public static int getResult(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        System.out.print(Arrays.toString(maxn));
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        System.out.println("\n"+getResult(new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}},9));
    }
}