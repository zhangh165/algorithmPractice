package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySort {
    public static String frequencySort(String s) {
        return frequencySort(s.toCharArray());
    }

    private static String frequencySort(char[] chars){
        Map<String,Integer> map = new HashMap<>();
        for(char c:chars){
            String str = c+"";
            if(!map.containsKey(str)){
                map.put(str,1);
            }else {
                map.put(str,map.get(str)+1);
            }
        }
        Queue<Map.Entry<String,Integer>> queue = new PriorityQueue<>((x, y)->y.getValue()-x.getValue());
        queue.addAll(map.entrySet());
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            Map.Entry<String,Integer> e = queue.poll();
            for(int i=0;i< e.getValue();i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(frequencySort("raaeaedere"));
    }
}
