package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LT841_canVisitAllRooms {
    public static boolean getResult(List<List<Integer>> rooms){
        int[] hash = new int[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.addAll(rooms.get(0));
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(hash[temp] == 1) {
                continue;
            }
            hash[temp]= 1;
            stack.addAll(rooms.get(temp));
        }
        int temp = 1;
        for(int i:hash){
            temp&=i;
        }
        return temp == 1;
    }

    public static List<List<Integer>> dealData(int[][] data){
        List<List<Integer>> temp = new ArrayList<>();
        for(int[] array:data){
            List<Integer> list = new ArrayList<>();
            for(int i:array){
                list.add(i);
            }
            temp.add(list);
        }
        return temp;
    }

    public static void main(String[] args){
        System.out.println(getResult(dealData(new int[][]{
                {1,3},
                {3,1,0},
                {2},
                {0}
        })));
    }
}
