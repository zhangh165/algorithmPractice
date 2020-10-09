package com.zhh1011.algorithmPractice.unRecordPractice;

public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c=='('){
                left++;
            }else{
                right++;
            }
        }
        return Math.abs(left-right);
    }
}
