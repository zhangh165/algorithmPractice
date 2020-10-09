package com.zhh1011.algorithmPractice.Huawei;

public class HJ76 {
    public static String getResult(int n){
        double temp = ((n-1)*(2+2*(n-1)))/2;
        double begainNum = (Math.pow(n,3)-temp)/n;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n;i++){
            sb.append((int)begainNum+"+");
            begainNum+=2;
        }
        sb.deleteCharAt(sb.lastIndexOf("+"));
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(getResult(6));
    }
}
