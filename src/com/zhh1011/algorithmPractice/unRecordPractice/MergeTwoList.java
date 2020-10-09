package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;

public class MergeTwoList {
    private static int[] help = null;
    public static void mergSort(int[] array){
        help = new int[array.length];
        mergeSort(array,0,array.length-1);
    }
    private static void mergeSort(int[] array,int L,int R){
        if(L >= R){
            return;
        }
        System.out.print("L -->"+L);
        System.out.println(" R -->"+R);
        int mid = (L+R)/2;
        mergeSort(array,L,mid);
        mergeSort(array,mid+1,R);
        merge(array,L,mid,R);
    }
    private static void merge(int[] array,int L,int mid,int R){
        int leftIndex = L,rightIndex = mid+1;
        int i = leftIndex;
        while(leftIndex <=mid && rightIndex <=R){
            if(array[leftIndex] < array[rightIndex]){
                help[i] = array[leftIndex];
                leftIndex++;
            }else if(array[leftIndex] > array[rightIndex]){
                help[i] = array[rightIndex];
                rightIndex++;
            }else {
                help[i] = array[leftIndex];
                leftIndex++;
            }
            i++;
        }
        if(leftIndex>mid){

        }
        for(int j = L;j <=R;j++){
            array[j] = help[j];
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{6,8,2,3,5,7,9};
        mergSort(array);
        System.out.println(Arrays.toString(array));
    }
}
