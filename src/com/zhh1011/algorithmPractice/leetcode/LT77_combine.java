package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LT77_combine {
    private static List<List<Integer>> list = new LinkedList<>();
    private static int[] hash;
    private static int num;
    public static List<List<Integer>> getResult(int n,int k){
        hash = new int[k];
        num = n;
        Arrays.fill(hash,-1);
        helper(1,0);
        return list;
    }

    private static void helper(int n,int k){
        if(k == hash.length){
            List<Integer> resultList = new ArrayList<>(hash.length);
            for(int i:hash){
                resultList.add(i);
            }
            list.add(resultList);
            return;
        }
        for(int i = n;i <= num;i++){
            hash[k] = i;
            helper(i+1,k+1);
            hash[k] = -1;
        }
    }

    public static void main(String[] args){
        System.out.println(getResult(4,4));
    }
}
