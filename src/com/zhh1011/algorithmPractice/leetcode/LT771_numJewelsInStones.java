package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * author: dsa44
 * create time: 2020/10/2 9:55
 */
public class LT771_numJewelsInStones {
    public static int getResult(String J, String S) {
        int[] hash = new int[26];
        Arrays.fill(hash,0);

        for(char c:J.toCharArray()){
            if(c >= 'a'&&c <= 'z'){
                hash[c-'a'] = hash[c-'a'] == 2?3:1;
            }else {
                hash[c-'A'] = hash[c-'A'] == 1?3:2;
            }
        }

        int count = 0;
        for(char c:S.toCharArray()){
            if(c >= 'a'&&c <= 'z'){
                if(hash[c-'a'] == 1||hash[c-'a'] == 3){
                    count+=1;
                }
            }else {
                if(hash[c-'A'] == 2||hash[c-'A'] == 3){
                    count+=1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}