package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author: dsa44
 * create time: 2020/11/1 14:34
 */
public class LT140_wordBreak {
    private static int strLength;
    private static int[] help;
    private static Map<String,Integer> map;
    private static String str;
    private static Deque<String> stack;
    private static List<String> result;
    public static List<String> getResult(String s, List<String> wordDict) {
        str = s;
        strLength = s.length();
        help = new int[wordDict.size()];
        Arrays.fill(help,0);
        map = new HashMap<>();
        stack = new LinkedList<>();
        result = new ArrayList<>();
        for(int i = 0; i < wordDict.size();i++){
            map.put(wordDict.get(i),i);
        }
        dfs(0);
        return result;
    }

    private static void dfs(int begin){
        if(begin >= strLength){
            result.add(formatOutput(stack));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = begin;i < strLength;i++){
            sb.append(str.charAt(i));
            if(map.containsKey(sb.toString())){
                int index = map.get(sb.toString());
                stack.push(sb.toString());
                dfs(i+1);
                stack.poll();
            }
        }
    }

    private static String formatOutput(Deque<String> stack){
        StringBuilder sb = new StringBuilder(stack.toString());
        String[] arr = sb.substring(1,sb.length()-1).split(",");
        sb = new StringBuilder();
        sb.append("\"");
        for(int i = arr.length-1;i >= 0; i--){
            sb.append(arr[i].trim()+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("\"");
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(getResult("pineapplepenapple",
                Arrays.stream(new String[]{"apple", "pen", "applepen", "pine", "pineapple"}).collect(Collectors.toList())));
    }
}