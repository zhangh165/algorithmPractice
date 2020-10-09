package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 */
public class NetherlandsFlag {
    public void dealFlag(int[] array){
        int zero = -1,
            one = 0,
            two = array.length;
        while(one < two){
            if(array[one] == 0){
                swap(array,++zero,one++);
            }else if(array[one] == 2){
                swap(array,--two,one);
            }else {
                one++;
            }
        }
    }
    private void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args){
        int[] a = new int[]{0,1,1,2,0,2,1,1,2};
        new NetherlandsFlag().dealFlag(a);
        System.out.println(Arrays.toString(a));
    }
}
