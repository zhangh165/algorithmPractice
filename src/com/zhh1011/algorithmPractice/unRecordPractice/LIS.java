package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;

public class LIS {
    private static int LIS(int[] a){
        int[] dp = new int[a.length];
        int ans = -1;
        for(int i = 0; i < a.length;i++){
            dp[i] = 1;
            for(int j = 0;  j < i ; j ++){
                if(a[i] >= a[j] && (dp[j]+1 > dp[i])){
                    dp[i] = dp[j]+1;
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args){
        System.out.println(LIS(new int[]{1,2,3,-9,3,9,0,11}));
    }
}
