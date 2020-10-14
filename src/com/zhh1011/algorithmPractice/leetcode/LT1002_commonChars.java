package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author: dsa44
 * create time: 2020/10/14 10:37
 */
public class LT1002_commonChars {
    public static List<String> getResult(String[] A) {
        if(null == A || A.length == 0){return new ArrayList<>();}
        HashMap<String,Integer> map = new HashMap<>();
        int[][] hash = new int[A.length][26];
        List<String> result = new LinkedList<>();
        //init
        for(int i = 0;i < A.length;i++){
            for(char c:A[i].toCharArray()){
                hash[i][c-'a']+=1;
            }
        }

        for(int i = 0;i< 26;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < A.length;j++){
                min = Math.min(min,hash[j][i]);
            }
            String temp = (char)(i+'a')+"";
            while(min > 0){
                result.add(temp);
                min--;
            }
        }

        return result;
    }

    /**
     * 尝试用流解决问题
     * 不是很理想
     * @param A
     * @return
     */
    private static List<String> streamTest(String[] A){
        Map<String,Long> map = Arrays.stream(A)
                .map((x)->{
                        List<String> list= new LinkedList<>();
                        for(char c:x.toCharArray()){
                            list.add(String.valueOf(c));
                        }
                        return list;
                })
                .map((x)->
                        x.stream()
                         .collect(Collectors.groupingBy(Object::toString,Collectors.counting())))
                .reduce((x,y)->{ x.entrySet().retainAll(y.entrySet()); return x;})/* 这里得lamda表达式有问题，交集结果并不符合题意*/
                .get();
        for (Map.Entry<String,Long> e:
             map.entrySet()) {
            System.out.println(e.toString());
        }
        List<String> result = new LinkedList<>();
        for (Map.Entry<String,Long> e:
                map.entrySet()) {
            for(int i = 0;i < e.getValue();i++){
                result.add(e.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"cool","lock","cook"};
        System.out.println(getResult(A));
        System.out.println(streamTest(A));
    }
}