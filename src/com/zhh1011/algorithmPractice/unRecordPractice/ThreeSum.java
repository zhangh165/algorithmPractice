package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            int left = 0,right = nums.length-1;
            int num = -nums[i];
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum>num){
                    right--;
                }else if(sum<num){
                    left++;
                }else{
                    if(left!=i&&right!=i&&set.add(nums[i]*nums[left]*nums[right]==0?nums[i]^nums[left]^nums[right]:nums[i]*nums[left]*nums[right])){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        list.add(ans);
                    }
                    left++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        for(List<Integer> list:new ThreeSum().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6})) {
            System.out.println(list);
        }
    }
}
