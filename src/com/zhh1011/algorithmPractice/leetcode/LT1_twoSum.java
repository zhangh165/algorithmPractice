package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author: dsa44
 * create time: 2020/10/3 9:33
 */
public class LT1_twoSum {
    public static int[] getResult(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int i= 0,j =0;
        for(i = 0;i < nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else{
                j = map.get(target-nums[i]);
                break;
            }
        }
        return new int[]{i,j};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getResult(new int[]{3,2,4},6)));
    }
}