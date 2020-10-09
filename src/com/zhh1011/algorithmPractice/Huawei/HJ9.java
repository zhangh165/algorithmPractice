package com.zhh1011.algorithmPractice.Huawei;

import java.util.Arrays;

public class HJ9 {
    public static String getResult(Integer num){
        char[] chars = num.toString().toCharArray();
        int[] hash = new int[10];
        Arrays.fill(hash,-1);
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length-1;i >=0;i--){
            int temp = (chars[i] - '0');
            if(hash[temp] == -1){
                sb.append(temp);
                hash[temp] = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(getResult(9876673));
    }
}
