package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ55 {
    public static void getResult(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n;i++){
            Integer temp = new Integer(i);
            if(temp.toString().contains("7") || temp%7==0){
                sb.append(temp+",");
            }
        }
        System.out.println(sb.toString().split(",").length);
    }

    public static void main(String[] args){
        getResult(30000);
    }
}
