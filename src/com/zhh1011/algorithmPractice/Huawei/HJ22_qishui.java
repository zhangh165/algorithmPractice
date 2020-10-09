package com.zhh1011.algorithmPractice.Huawei;

public class HJ22_qishui {
    public static void getDeal(int num){
        if(num <= 0 && num%3!= 0){
            System.out.println(0);
        }
        int result = 0;
        while(num >= 3){
            int temp = num /3;
            result+=temp;
            num = num%3 + temp;
        }
        System.out.println(result);
    }

    public static void main(String[] args){

    }
}
