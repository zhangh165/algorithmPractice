package com.zhh1011.algorithmPractice.Huawei;

public class HM_T_1 {
    public static String getResult(int n){
        int temp = n;
        StringBuilder sb = new StringBuilder();
        while(n!=1){
            for(int i = 2;i <= n;i++){
                if(n%i==0){
                    sb.append(i+"*");
                    n = n / i;
                    break;
                }
            }
        }

        return sb.deleteCharAt(sb.lastIndexOf("*")).toString()+"="+temp;
    }

    public static void main(String[] args){
        System.out.println(getResult(100));
    }
}
