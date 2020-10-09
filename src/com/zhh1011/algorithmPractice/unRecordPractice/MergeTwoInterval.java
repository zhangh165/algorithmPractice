package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoInterval {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        int left = intervals[0][0],right = intervals[0][1];
        for(int[] a:intervals){
            if(right>=a[0]){
                right = right>=a[1]?right:a[1];
                continue;
            }else{
                list.add(new int[]{left,right});
                left = a[0];
                right = a[1];
            }
        }
        list.add(new int[]{left,right});
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args){
        for(int[] a: new MergeTwoInterval().merge(new int[][]{{1,4},{0,4}})){
            System.out.println(Arrays.toString(a));
        }
    }
}
