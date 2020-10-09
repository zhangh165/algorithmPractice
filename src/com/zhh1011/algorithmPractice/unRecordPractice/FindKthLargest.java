package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((x,y)->y-x);
        for(int i:nums){
            queue.add(i);
        }
        int re = 0;
        for(int i=0;i<k;i++){
             re = queue.poll();
        }
        return re;
    }

    public static void main(String[] args){
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
