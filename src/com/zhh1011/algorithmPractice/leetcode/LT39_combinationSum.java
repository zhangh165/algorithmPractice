package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;

public class LT39_combinationSum {
    private static int targetNum;
    private static int[] targetArray;
    private static Deque<Integer> deque = new LinkedList<>();
    private static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> getResult(int[] array,int target){
        targetNum = target;
        targetArray = array;
        Arrays.sort(array);
        dfs(target,0);
        return result;
    }

    public static void dfs(int target,int k){
        if(target == 0){
            List<Integer> list = new ArrayList<>(deque);
            result.add(list);
            return;
        }
        for(int i = k;i < targetArray.length;i++){
            int temp = targetArray[i];
            if(temp > target){
                return;
            }
            deque.push(temp);
            dfs(target-temp,i);
            deque.poll();
        }
    }

    public static void main(String[] args){
        System.out.println(getResult(new int[]{2,3,5},8));
    }
}
