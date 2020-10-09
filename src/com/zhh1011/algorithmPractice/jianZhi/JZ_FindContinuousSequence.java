package com.zhh1011.algorithmPractice.jianZhi;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ_FindContinuousSequence {
    public int[][] FindContinuousSequence(int sum) {
        ArrayList<int[]> lists = new ArrayList<>();
        for(int i = 1;i <= sum/2;i++){
            int right = sum/2,left = i;
            while(left <= right){
                int mid = (left+right)/2;
                int result = Math.round((i+mid)*(mid-i+1)/2);
                if(result > sum){
                    right = mid-1;
                }else if(result < sum){
                    left = mid+1;
                }else {
                    if(i!=mid) {
                        System.out.println("i " + i + " mid" + mid);
                        lists.add(getResult(i, mid));
                        break;
                    }
                }
            }
        }
        int[][] an = new int[lists.size()][];
        int count = 0;
        for(int[] list:lists){
            an[count] = list;
            count++;
        }
        return an;
    }

    private int[] getResult(int start,int end){
        int[] a = new int[end-start+1];
        for(int i = start;i <=end;i++){
            a[i-start] = i;
        }
        return a;
    }

    public static void main(String[] args){
        JZ_FindContinuousSequence test = new JZ_FindContinuousSequence();
        for(int[] a:test.FindContinuousSequence(87760)){
            System.out.println(Arrays.toString(a));
        }
    }
}
