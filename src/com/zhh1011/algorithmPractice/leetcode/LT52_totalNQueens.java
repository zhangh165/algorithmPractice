package com.zhh1011.algorithmPractice.leetcode;

/**
 * author: dsa44
 * create time: 2020/10/17 10:15
 */
public class LT52_totalNQueens {
    private static int[] result;
    private static int count = 0;
    public static int getResult(int n) {
        if(n < 1){return n;}
        result = new int[n];
        helper(0);
        return count;
    }

    private static void helper(int k){
        if(k == result.length){
            count++;
            return;
        }
        for(int i = 0;i < result.length;i++){
            result[k] = i;
            if(check(result,k)){
                helper(k+1);
            }else {
                continue;
            }
        }
    }

    private static boolean check(int[] result,int k){
        for(int i=0;i < k;i++){
            int high = Math.abs(result[k]-result[i]);
            int longx = Math.abs(k - i);
            if(high == longx ||high==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getResult(10));
    }
}