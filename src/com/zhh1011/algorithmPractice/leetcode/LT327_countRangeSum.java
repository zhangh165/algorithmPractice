package com.zhh1011.algorithmPractice.leetcode;

/**
 * author: dsa44
 * create time: 2020/11/7 12:33
 */
public class LT327_countRangeSum {
    public static int getResult(int[] nums, int lower, int upper) {
        long[][] dp = new long[nums.length][nums.length];
        int count = 0;
        for(int i =0;i < nums.length;i++){
            dp[i][i] = nums[i];
            if(dp[i][i]>=lower&&dp[i][i] <=upper){
                count++;
            }
        }
        for(int i = 0; i < nums.length;i++){
            for(int j= i+1; j < nums.length;j++){
                dp[i][j] = dp[i][j-1]+nums[j];
                if(dp[i][j]>=lower&&dp[i][j] <=upper){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{-2147483647,0,-2147483647,2147483647},-564,3864));
    }
}