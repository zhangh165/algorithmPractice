package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * author: dsa44
 * create time: 2020/9/20 11:38
 */
public class LT78_subsets {
    private static Deque<Integer> state = new LinkedList<>();
    private static int[] target;
    private static List<List<Integer>> result = new LinkedList<>();
    public static List<List<Integer>> getResult(int[] nums) {
        target = nums;
        dfs(0);
        return result;
    }

    private static void dfs(int index){
        if(index == target.length){
            return;
        }
        for(int i = index;i < target.length;i++){
            state.push(target[i]);
            saveState();
            dfs(i+1);
            state.poll();
        }
    }

    private static void saveState(){
        ArrayList<Integer> list = new ArrayList<>(state);
        result.add(list);
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{1,2,3,4}));
    }
}