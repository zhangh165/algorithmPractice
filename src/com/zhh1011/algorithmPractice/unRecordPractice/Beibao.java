package com.zhh1011.algorithmPractice.unRecordPractice;

/**
 * author: dsa44
 * create time: 2020/10/19 15:22
 */
public class Beibao {

    public static int getResult(int v,int[] value,int[] w) {
        int[] dp = new int[v+1];

        for(int i = 0;i < value.length;i++){
            for(int j = v; j >=w[i];j--){
                dp[j] = Math.max(dp[j],dp[j-w[i]]+value[i]);
            }
        }

        int result = -1;
        for(int i:dp){
            result = Math.max(result,i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResult(8,new int[]{4,5,2,1,3},new int[]{3,5,1,2,2}));
    }
}