package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;

/**
 * author: dsa44
 * create time: 2020/10/22 23:18
 * TODO : 重写
 */
public class LT763_partitionLabels {
    public static List<Integer> getResult(String S) {
        int[] hash = new int[26];
        int[] result = new int[S.length()];
        Arrays.fill(hash,-1);
        Set<String> set = new HashSet<>();
        int[] h = new int[S.length()];
        for(int i = 0; i < S.length();i++){
                hash[S.charAt(i)-'a'] = i;
        }
        System.out.println(Arrays.toString(hash)+" "+hash.length);
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, hash[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        System.out.println(getResult("ababcbacadefegdehijhklij"));
    }
}