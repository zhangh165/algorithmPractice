package com.zhh1011.algorithmPractice.leetcode;

public class LWD524 {
    public static String findLongestWordArray(String str,String[] words){
        String longestWord = "";
        int longestWordLen = 0;
        for (String word:
                words) {
            if(longestWordLen > word.length()||(longestWordLen == word.length() && longestWord.compareTo(word) < 0)){
                continue;
            }
            if(isMartch(str,word)){
                longestWord = word;
                longestWordLen = word.length();
            }
        }
        return longestWord;
    }

    private static boolean isMartch(String str,String word){

        char[] chars = str.toCharArray();
        char[] wordChars = word.toCharArray();
        int i = 0,j = wordChars.length-1;
        int w = 0,m = chars.length-1;
        while (i < j && w < m){
            while (chars[w] == wordChars[i]) {
                i++;
                w++;
            }
            w++;
            while (chars[m] == wordChars[j]){
                m--;
                j--;
            }
            m--;
        }
        return j==i;
    }

    public static void main(String[] args){
        System.out.println(findLongestWordArray("aewfafwafjlwajflwajflwafj",new String[]{"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"}));
    }

}
