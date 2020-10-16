package com.zhh1011.algorithmPractice.unRecordPractice;

/**
 * author: dsa44
 * create time: 2020/10/16 13:34
 * 寻找丢失数字
 */
public class findMissingNumber {
    public static int getResult(int[] input) {
        int i = 0, j = input.length-1;
        while (i<j-1){
            int k = (i+j)/2;
            if(input[k] == k){
                i = k;
            }else {
                j = k;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{0, 2}));
    }
}