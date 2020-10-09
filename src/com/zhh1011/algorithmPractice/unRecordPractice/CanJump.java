package com.zhh1011.algorithmPractice.unRecordPractice;

public class CanJump {
    public boolean canJump(int[] nums) {
        int farDistance = 0;
        for(int i=0;i<nums.length;i++){
            if(farDistance<i){
                return false;
            }else {
                farDistance = Math.max(farDistance,i+nums[i]);
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new CanJump().canJump(new int[]{2,3,1,1,4}));
    }
}
