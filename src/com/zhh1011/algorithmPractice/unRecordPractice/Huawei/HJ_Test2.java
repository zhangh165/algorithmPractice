package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HJ_Test2 {
    public static int getResult(int[] array1,int[] array2,int k){
        Arrays.sort(array1);
        Arrays.sort(array2);
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i =0;i< array1.length;i++){
            for (int j = 0; j < array2.length;j++){
                queue.add(array1[i]+array2[j]);
            }
        }
        int result = 0;
        for(int l = 0; l<k;l++){
            result+=queue.poll();
        }
        return result;
    }

    public static int[] dealInput(String str){
        String[] array = str.split(" ");
        int[] values = new int[array.length];
        for (int i = 0;i < array.length;i++){
            values[i] = Integer.parseInt(array[i]);
        }
        return values;
    }

    /**
     * 3 1 1 2
     * 3 1 2 3
     * 2
     * @param args
     */
    public static void main(String[] args){
        System.out.println(getResult(dealInput("3 1 1 2"),dealInput("3 1 2 3"),2));
    }
}
