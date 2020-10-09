package com.zhh1011.algorithmPractice.leetcode;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0,j = 0;
        int length = nums.length;
        for(i = 0;i < length;i++){
            for(j = i+1;j< length;j++){
                if(i == j){
                    continue;
                }
                if(nums[i]+nums[j] == target){
                    int[] aws = new int[]{i,j};
                    return aws;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        for (int a:
                twoSum(new int[]{3,2,4},6)) {

            System.out.println(a);
        }
    }

}
