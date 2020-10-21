package com.zhh1011.algorithmPractice.leetcode;

/**
 * author: dsa44
 * create time: 2020/10/21 10:07
 */
public class LT925_isLongPressedName {
    public static boolean getResult(String name, String typed) {
        if(null == name||null == typed){return false;}
        int i = 0, j = 0;
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i)!=typed.charAt(j)){
                return false;
            }
            int countN = 0,countT = 0;
            while(i < name.length()-1&&name.charAt(i)==name.charAt(i+1)){
                countN++;
                i++;
            }
            while(j < typed.length()-1&&typed.charAt(j)==typed.charAt(j+1)){
                countT++;
                j++;
            }
            if(countN > countT){
                return false;
            }
            i++;
            j++;
        }
        return i == name.length()&&j==typed.length();
    }

    public static void main(String[] args) {
        System.out.println(getResult("pyplrz","ppyypllr"));
    }
}