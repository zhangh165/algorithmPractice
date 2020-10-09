package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0,j = chars.length-1;

        while(i <= j){
            while(!vowels.contains(chars[i])&&i<j) {
                i++;
            }
            while(!vowels.contains(chars[j])&&i<j) {
                j--;
            }
            swap(chars,i,j);
            i++;
            j--;
            System.out.println("-->"+i+" "+j);
        }
        String str = "";
        for(char c:chars){
            str+=c;
        }
        str+=i;
        str+=j;
        return str;
    }
    private static void swap(char[] chars,int i,int j){
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args){
        assert(reverseVowels("hello").equals("holle"));
    }
}
