package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.*;

public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
               map.put(i,1);
            }else {
               map.put(i,map.get(i)+1);
            }
        }
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((x,y)->y.getValue()-x.getValue());
        queue.addAll(map.entrySet());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< k;i++){
            list.add(queue.poll().getKey());
        }
        return list;
    }

    public static void main(String[] args){
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}
