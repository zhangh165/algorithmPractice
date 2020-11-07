package com.zhh1011.algorithmPractice.leetcode;

/**
 * author: dsa44
 * create time: 2020/10/25 9:13
 */
public class LT845_longestMountain {
    public static int getResult(int[] A) {
        if(null == A || A.length < 3){return 0;}
        int reslut = 0;
        for(int i = 0,count = 0; i < A.length;i++){
            int curNum = A[i],j = 1,leftNum = curNum,rightNum = curNum;
            if(j <= i&& j < A.length-i&&A[i-j] < leftNum && A[i+j] < rightNum){
                while(j <= i&&A[i-j] < leftNum ){
                    count++;
                    leftNum = A[i-j];
                    j++;
                }
                j=1;
                while(j < A.length-i&&A[i+j] < rightNum ){
                    count++;
                    rightNum = A[i+j];
                    j++;
                }
                reslut = Math.max(count,reslut);
                count = 0;
            }
        }
        return reslut == 0?0:reslut+1;
    }

    public static void main(String[] args) {
        System.out.print(getResult(new int[]{2,2,2}));
    }
}