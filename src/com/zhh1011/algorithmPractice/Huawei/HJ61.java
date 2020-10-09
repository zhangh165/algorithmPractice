package com.zhh1011.algorithmPractice.Huawei;

public class HJ61 {
    public static int getResult(int m,int n){
        if(m<0){
            return 0;
        }else if( m == 1 || n == 1){
            return 1;
        }else {
            return getResult(m,n-1)+getResult(m-n,n);
        }
    }

    public static void main(String[] args){
        System.out.println(getResult(4,10));
    }
}
