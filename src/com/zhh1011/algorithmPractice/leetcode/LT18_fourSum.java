package com.zhh1011.algorithmPractice.leetcode;

import java.util.*;

/**
 * author: dsa44
 * create time: 2020/10/5 20:11
 */
public class LT18_fourSum {
    private static Set<List<Integer>> result = new HashSet<>();
    public static List<List<Integer>> getResult(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            return new ArrayList<>(result);
        }
        Arrays.sort(nums);
        if(nums[nums.length-4]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1] < target
                || nums[0]+nums[1]+nums[2]+nums[3] > target){
            return new ArrayList<>(result);
        }
        helper(nums,new LinkedList<Integer>(),0,0,target);
        return new ArrayList<>(result);
    }

    private static void helper(int[] nums, Deque<Integer> stack, int k, int sum,int target){
        if(sum == target&&stack.size()==4){
            result.add(new ArrayList<>(stack));
            return;
        }
        for(int i = k;i < nums.length;i++){
            stack.push(nums[i]);
            if(stack.size() > 4){
                stack.poll();
                return;
            }
            sum+=nums[i];
            helper(nums,stack,i+1,sum,target);
            sum-=nums[i];
            stack.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{1,0,-1,0,-2,2},0));
    }
}