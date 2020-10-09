package com.zhh1011.algorithmPractice.jianZhi;

import java.util.ArrayList;

public class JZ_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int i=0,j=array.length-1;
        int curAn = array[i]+array[j];
        ArrayList<Integer> list = new ArrayList<>();
        while(i<j){
            if(curAn > sum){
                j--;
                curAn=array[i]+array[j];
            }else if(curAn < sum){
                i++;
                curAn=array[i]+array[j];
            }else{
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args){
        JZ_FindNumbersWithSum test = new JZ_FindNumbersWithSum();
        System.out.println(test.FindNumbersWithSum(new int[]{1,2,4,7,11,15},15));
    }
}
