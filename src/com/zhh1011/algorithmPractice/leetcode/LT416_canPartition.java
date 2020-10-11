package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * author: dsa44
 * create time: 2020/10/11 10:17
 * 实际上该解法超时，只解决了36/115
 * 最佳解法应该为01背包问题，将背包容量设为 sum/2
 */
public class LT416_canPartition {
    public static boolean getResult(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if((sum&1) == 1){
            return false;
        }
        sum /= 2;

        return dfs(0,0,sum,nums);
    }

    private static boolean dfs(int k,int target,int sum,int[] nums){
        if(target == sum) return true;
        if(target < sum && k >= nums.length) return false;
        if(target > sum) return false;
        boolean result = false;
        for(int i = k;i < nums.length;i++){
            result = result || dfs(i+1,target+nums[i],sum,nums);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{23,13,11,7,6,5,5}));
    }
}