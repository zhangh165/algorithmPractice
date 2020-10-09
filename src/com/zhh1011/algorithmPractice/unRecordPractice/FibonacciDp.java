package com.zhh1011.algorithmPractice.unRecordPractice;

public class FibonacciDp {
    private static int F(int n){
        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i< n ;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        System.out.println(F(6));
    }
}
