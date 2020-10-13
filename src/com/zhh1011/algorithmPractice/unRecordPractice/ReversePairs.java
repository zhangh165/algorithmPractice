package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=getDeal(nums,i);
        }
        return sum;
    }

    private int getDeal(int[] nums,int first){
        int length = nums.length-first-1;
        int[] a = new int[length];
        a = Arrays.copyOfRange(nums,first,nums.length);
        Arrays.sort(a);
        for(int i = a.length-1;i>=0;i--){
            if(nums[first] > a[i]){
                return i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(new ReversePairs().reversePairs(new int[]{2,3,2,4,1}));
    }
}
