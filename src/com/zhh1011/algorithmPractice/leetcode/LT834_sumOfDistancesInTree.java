package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;

/**
 * author: dsa44
 * create time: 2020/10/6 10:01
 */
public class LT834_sumOfDistancesInTree {
    private static int[][] dp = null;

    private static ArrayList<Integer>[] lists = null;
    public static int[] getResult(int N, int[][] edges) {
        dp = new int[N][N];
        lists = new ArrayList[N];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] ar = edges[i];
            lists[ar[0]].add(ar[1]);
            lists[ar[1]].add(ar[0]);
            dp[ar[0]][ar[1]] = 1;
            dp[ar[1]][ar[0]] = 1;
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int distanceSum = 0;
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    continue;
                } else {
                    int max = i > j ? i : j, min = i > j ? j : i;
                    if (dp[min][max] != -1) {
                        distanceSum += dp[min][max];
                    } else {
                        dp[min][max] = dfs(min, max, 0);
                        distanceSum += dp[min][max];
                    }
                }
            }
            result[i] = distanceSum;
        }
        return result;
    }


    private static int dfs(int i,int j,int dis){
        if(lists[i].contains(j)){
            return dis;
        }else {
            for(int k:lists[i]){
                dis=dfs(k,j,dis+1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                getResult(6,
                        new int[][]{
                                {0,1},
                                {0,2},
                                {2,3},
                                {2,4},
                                {2,5}})
        ));
    }
}