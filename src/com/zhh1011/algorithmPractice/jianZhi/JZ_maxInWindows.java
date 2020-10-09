package com.zhh1011.algorithmPractice.jianZhi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class JZ_maxInWindows {
    public ArrayList<Integer> maxInWindows(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            if(!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                list.add(nums[queue.peek()]);
            }
        }
        return list;
    }

    public static void main(String[] args){
        System.out.println(new JZ_maxInWindows().maxInWindows(new int[]{2,3,4,2,6,2,5,1},3));
    }
}
