package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.List;

public class AB_25 {
    private static List<String> list = new ArrayList<>();
    public static void getResult(int n){
        StringBuilder sb = new StringBuilder();
        helper(sb,n);
        output();
    }

    public static void helper(StringBuilder sb,int num){
        if(num <= 0){
            list.add(sb.toString());
        }
        for(int i = num;i > 0;i--){
            String temp = sb.toString();
            sb.append(i+"+");
            helper(sb,num-i);
            sb = new StringBuilder(temp);
        }
    }

    public static void output(){
        for(String s:list){
            System.out.println(s.substring(0,s.length()-1));
        }
    }

    public static void main(String[] args){
        getResult(6);
    }
}
