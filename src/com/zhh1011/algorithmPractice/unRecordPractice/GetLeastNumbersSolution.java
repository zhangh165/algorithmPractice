package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbersSolution {
    public static ArrayList<Integer> GetLeastNumbersSolution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x,y)->x-y);
        for(int i:input){
            queue.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args){
        for(int i:GetLeastNumbersSolution(new int[]{4,5,1,6,2,7,3,8},4)) {
            System.out.println(i);
        }
    }
}
