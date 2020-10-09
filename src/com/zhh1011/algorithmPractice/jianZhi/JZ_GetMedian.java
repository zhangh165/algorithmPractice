package com.zhh1011.algorithmPractice.jianZhi;

import java.util.PriorityQueue;
import java.util.Queue;

public class JZ_GetMedian {
    Queue<Integer> leftHeap = new PriorityQueue<>((x,y)->y-x);
    Queue<Integer> rightHeap = new PriorityQueue<>((x,y)->x-y);
    public void Insert(Integer num) {
        if(rightHeap.isEmpty()){
            rightHeap.add(num);
            return;
        }
        if(Math.abs(leftHeap.size()-rightHeap.size())<2){
            if (num < rightHeap.peek()){
                leftHeap.add(num);
            }else {
                rightHeap.add(num);
            }
        }else {
            balanceTwoHeap();
            Insert(num);
        }
    }
    private void balanceTwoHeap(){
        if(leftHeap.size()>rightHeap.size()){
            int maxLeft = leftHeap.poll();
            rightHeap.add(maxLeft);
        }else {
            int minRight = rightHeap.poll();
            leftHeap.add(minRight);
        }
    }
    public Double GetMedian() {
        if(Math.abs(leftHeap.size()-rightHeap.size())>=2){
            balanceTwoHeap();
        }
        if(leftHeap.size()==rightHeap.size()){
            return ((double)(leftHeap.peek()+rightHeap.peek())/2);
        }else {
            return (double)(leftHeap.size()>rightHeap.size()?leftHeap.peek():rightHeap.peek());
        }
    }

    public static void main(String[] args){
        JZ_GetMedian median = new JZ_GetMedian();
        InsertAll(median,new int[]{5,2,3,4,1,6,7,0,8});

    }
    private static void InsertAll(JZ_GetMedian median,int[] a){
        for (int i:
             a) {
            median.Insert(i);
            System.out.println(median.GetMedian());
        }
    }
}
