package com.zhh1011.algorithmPractice.unRecordPractice;

public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        return validPalindrome(s.toCharArray(),0,s.length()-1);
    }

    private static boolean validPalindrome(char[] chars,int i,int j){
        while(i<j){
            if(chars[i]==chars[j]){
                i++;
                j--;
            }else{
                return validPalindrome1(chars,i,j-1)||validPalindrome1(chars,i+1,j);
            }
        }
        return true;
    }

    private static boolean validPalindrome1(char[] chars,int i,int j){
        while(i<j){
            if(chars[i]==chars[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(validPalindrome("acb"));
    }

}
