package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ86 {
    public static int getResult(int n){
        int count = 0,result = 0;
        while(n != 0){
            if((n & 1) != 0){
                count++;
                System.out.println(count);
            }else {
                result = Math.max(result,count);
                count=0;
            }
            n = n >>>1;
        }
        result = Math.max(result,count);
        return result;
    }

    public static void main(String[] args){
        System.out.println(getResult(200));
    }
}
