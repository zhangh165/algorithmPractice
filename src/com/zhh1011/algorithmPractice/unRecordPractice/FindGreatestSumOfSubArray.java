package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;

public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length+1];
        int max = 0;
        dp[0] = 0;
        for(int i =1;i<dp.length;i++){
            dp[i] = i-1;
        }
        for(int i=0;i<array.length;i++){
            if(array[i] > 0){
                int sum = getValue(array,dp[i],i-1);
                dp[i+1] =  sum+array[i] > sum && sum>0?dp[i]:i;
                max = Math.max(max,sum+array[i]);
                System.out.print("-->"+(sum+array[i]));
                System.out.println("-->"+max);
            }else {
                dp[i+1] = dp[i];
            }
        }
        System.out.println("-->"+Arrays.toString(array));
        System.out.println(Arrays.toString(dp));
        return max;
    }

    private static int getValue(int[] a,int i,int j) {
        int sum = 0;
        for(int x = i; x <=j;x++){
            sum+=a[x];
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.print(FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }
}
