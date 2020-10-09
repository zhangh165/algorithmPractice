package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class WindTest {
    public static ArrayList<Integer[]> getResult(int[] nums,int target){
        int i = 0,j = nums.length-1;
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        while (i < j){
            if(nums[i] * nums[j] >target){
                j--;
            }else if(nums[i] * nums[j] <target){
                i++;
            }else {
                list.add(new Integer[]{nums[i],nums[j]});
                j--;
            }
        }
        if (list.isEmpty()){
            list.add(new Integer[]{-1,-1});
        }
        return list;
    }

    public static void main(String[] args){
        for(Integer[] arr:getResult(new int[]{5,7,9,10,13},64)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
