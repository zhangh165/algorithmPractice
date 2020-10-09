package com.zhh1011.algorithmPractice.QSort;

import java.util.Arrays;

public class SortMethod {
    public static int[] bSort(int[] array){
        int count = 0;
        do{
            count = 0;
            for(int i = 0; i < array.length-1;i++){
                if(array[i] > array[i+1]){
                    swp(array,i,i+1);
                    count++;
                }
            }
        }while (count!=0);
        return array;
    }

    public static int[] cSort(int[] array){
        int index = 0;
        while(index < array.length){
            int min = array[index],minIndex = index;
            for(int i = index;i < array.length;i++){
                if(array[i] < min){
                    minIndex = i;
                    min = array[i];
                }
            }
            swp(array,index,minIndex);
            index++;
        }
        return array;
    }

    public static int[] iSort(int[] array){

        return array;
    }

    public static int[] qSort(int[] array){
        parter(array,0,array.length-1);
        return array;
    }

    private static void parter(int[] array,int low,int high){
        if(low == high-1) {
            if(array[low] > array[high]) {
                swp(array,low,high);
            }
        }else if(low>=high){
                return;

        }
        int lowerIndex = low,
                higherIndex = high;
        int index = low;
        int head = array[low];
        while(index <= higherIndex){
            if(array[index] < head){
                swp(array,lowerIndex,index);
                lowerIndex++;
                index++;
            }else if(array[index] == head){
                index++;
            }else{
                swp(array,higherIndex,index);
                higherIndex--;
            }
        }
        parter(array,low,lowerIndex-1);
        parter(array,higherIndex,high);
    }

    public static void swp(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args){
        int[] arrya = new int[]{2,1,5,7,4};
        System.out.println(Arrays.toString(bSort(new int[]{2,1,5,7,4})));
        System.out.println(Arrays.toString(qSort(new int[]{2,1,5,7,4})));
    }
}
