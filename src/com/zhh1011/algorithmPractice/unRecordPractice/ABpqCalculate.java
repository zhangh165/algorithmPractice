package com.zhh1011.algorithmPractice.unRecordPractice;

import com.zhh1011.algorithmPractice.dataStructure.MyQueue;

public class ABpqCalculate {
    public static int searchResult(int[] array){
        int a = array[0];
        int b = array[1];
        int p = array[2];
        int q = array[3];

        MyQueue<int[]> queue = new MyQueue<int[]>();

        int[] value = new int[]{a,p,0};
        queue.push(value);
        int[] temp = null;
        while (true){
            temp = queue.getFront();
            queue.pop();
            if(temp[0] >= b){
                break;
            }else {
                queue.push(new int[]{temp[0]+temp[1],temp[1],temp[2]+1});
                queue.push(new int[]{temp[0],temp[1]*q,temp[2]+1});
            }
        }
        return temp[2];
    }

    public static void main(String[] args){
        System.out.println(searchResult(new int[]{1,15,4,2}));
    }
}