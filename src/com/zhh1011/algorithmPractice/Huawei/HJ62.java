package com.zhh1011.algorithmPractice.Huawei;

public class HJ62 {
    public static int getResult(int n){
        int i = n;
        int count = 0;
        while(n != 0){
            if((n&1) != 0){
                count++;
            }
            n=n >> 1;
        }
        System.out.println(count);
        return Integer.bitCount(i);
    }

    public static void main(String[] args){
        System.out.println(getResult(5));
    }
}
