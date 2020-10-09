package com.zhh1011.algorithmPractice.unRecordPractice;

public class MaxArea {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int ans = 0;
        while(i<j){
            ans = Math.max(ans,Math.max(height[i],height[j])*(j-i));
            if(height[i]>height[j]) {
                j--;
            }else {
                i++;
            }
        }
        return ans;
    }
}
