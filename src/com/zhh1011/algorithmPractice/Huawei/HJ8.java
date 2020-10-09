package com.zhh1011.algorithmPractice.Huawei;

import java.util.*;

public class HJ8 {
    private static HashMap<Integer,Integer> map = new HashMap<>();
    public static String getResult(){
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((x, y)->x.getKey()-y.getKey());
        queue.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> temp = queue.poll();
            sb.append(temp.getKey()+" "+temp.getValue()+"\n");
        }
        return sb.toString();
    }

    public static void inputValue(String str){
        String[] strs = str.split(" ");

        if(!map.containsKey(Integer.parseInt(strs[0]))) {
            map.put(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        }else {
            map.put(Integer.parseInt(strs[0]), map.get(Integer.parseInt(strs[0]))+Integer.parseInt(strs[1]));
        }
    }

    public static void main(String[] args){
        inputValue("0 1");
        inputValue("0 2");
        inputValue("3 4");
        inputValue("2 1");
        System.out.println(getResult());
    }
}
