package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_ReverseSentence {
    public String ReverseSentence(String str) {
        if(str==null||str.equals("")||str.equals(" ")){
            return str;
        }
        String[] strs = str.trim().split(" +");
        int left = 0,right = strs.length-1;
        while(left < right){
            String temp = strs[left];
            strs[left] = strs[right];
            strs[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s+" ");
        }
        while(sb.lastIndexOf(" ")==sb.length()-1) {
            sb.replace(sb.lastIndexOf(" "), sb.length(), "");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println((new JZ_ReverseSentence().ReverseSentence("a good   example"))+"|");
    }
}
