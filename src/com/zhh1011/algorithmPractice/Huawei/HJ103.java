package com.zhh1011.algorithmPractice.Huawei;

import java.util.Arrays;

public class HJ103 {
    public static int getResult(int[] nums){
        int[] dp =new int[nums.length];
        int result = Integer.MIN_VALUE;
        for(int i = 1;i < nums.length;i++){
            dp[i] = 1;
            for(int j = 1; j < i;j++){
                if(nums[i] > nums[j] && dp[j]+i > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            result = Math.max(result,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] args){
        System.out.println(getResult(new int[]{6,2,5,1,5,4,5}));
    }
}
