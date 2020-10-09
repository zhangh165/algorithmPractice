package com.zhh1011.algorithmPractice.leetcode;

public class LT557_reverseWords3 {
    public static String getResult(String s){
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(reverseWord(str)+" ");
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb.toString();
    }

    public static String reverseWord(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length-1;i >= 0;i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
