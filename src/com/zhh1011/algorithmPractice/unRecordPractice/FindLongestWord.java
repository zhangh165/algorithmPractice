package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLongestWord {
    public static String findLongestWord(String s, List<String> d) {
        char[] chars = s.toCharArray();
        String longestWords = "";
        for(String str:d){
            if(str.length()<longestWords.length()||(str.length()==longestWords.length()&&longestWords.compareTo(str)<0)){
                continue;
            }
            if(findLongestWord(chars,str)){
                longestWords = str;
            }
        }
        return longestWords;
    }

    private static boolean findLongestWord(char[] chars,String d){
        int j = 0;
        for(int i=0;i < chars.length;i++){
            if(j<d.length()&&chars[i]==d.charAt(j)){
                j++;
            }
        }

        return j==d.length();
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list = Arrays.asList("ba","ab","a","b");
        System.out.println(findLongestWord("bab",list));
    }
}
