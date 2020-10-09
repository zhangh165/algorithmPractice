package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ6 {
    public static String getResult(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 2;i < n;i++){
            while(n != i){
                if(n % i != 0){
                    break;
                }
                n/=i;
                sb.append(i+" ");
            }
        }
        sb.append(n+" ");
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(getResult(90));
    }
}
