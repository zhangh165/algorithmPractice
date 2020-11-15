package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;

/**
 * author: dsa44
 * create time: 2020/10/26 21:28
 */
public class LT1365_smallerNumbersThanCurrent {
    public static int[] getResult(int[] nums) {
        Integer[] num = new Integer[nums.length];
        for(int i = 0; i < num.length;i++){
            num[i] = i;
        }
        Comparator<Integer> comparator = (Integer x,Integer y)->{return nums[x]-nums[y];};
        Arrays.sort(num,comparator);
        int[] result = new int[num.length];
        for(int i = 0; i < num.length;i++){
            int temp = num[i];
            result[temp] = i;
        }
        return result;
    }

    private static int[] helper(int[] nums){
        if(null == nums || nums.length == 0){return new int[nums.length];}
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        Comparator<Map.Entry<Integer,List<Integer>>> comparator = (x,y)->{return x.getKey() - y.getKey();};
        TreeSet<Map.Entry<Integer,List<Integer>>> sortedNums = new TreeSet<>(comparator);
        sortedNums.addAll(map.entrySet());
        int count = 0;
        for(Map.Entry<Integer,List<Integer>> e:sortedNums){
            for(int i:e.getValue()){
                result[i] = count;
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(helper(new int[]{8,1,2,2,3})));
    }
}