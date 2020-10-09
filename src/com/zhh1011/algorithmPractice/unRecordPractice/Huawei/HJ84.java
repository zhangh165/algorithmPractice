package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ84 {
    public static int getResult(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for(char c:chars){
            if(c >= 'A' && c <='Z'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(getResult("Aadd123#$%#%#O"));
    }
}
