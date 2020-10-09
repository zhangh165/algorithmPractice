package com.zhh1011.algorithmPractice.leetcode;

import java.util.Arrays;

/**
 * author: dsa44
 * create time: 2020/9/17
 */
public class LT4_findMedianSortedArrays {
    public static double getResult(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,array,0,nums1.length);
        System.arraycopy(nums2,0,array,nums1.length==0?0:nums1.length,nums2.length);
        Arrays.sort(array);
        int arrayLength = nums1.length+nums2.length;
        boolean isEven = (arrayLength&1) == 0;
        int medianIndex = isEven?arrayLength/2:(arrayLength+1)/2;

//        if(medianIndex == 1){
//            if(isEven){
//                return (nums1[0]+nums2[0])/2.0;
//            }else{
//                return nums1.length == 0?nums2[0]:nums1[0];
//            }
//        }
//
//        int nums1Low = 0,
//            nums2Low = 0,
//            nums1High = nums1.length-1,
//            nums2High = nums2.length-1;
//
//        int low = 0,high = 0;
//
//        for(int i = 0;i <medianIndex;i++){
//            if(nums1[nums1Low] < nums2[nums2Low]){
//                low = nums1[nums1Low++];
//            }else {
//                low = nums2[nums2Low++];
//            }
//
//            if(nums1[nums1High] > nums2[nums2High]){
//                high = nums1[nums1High--];
//            }else {
//                high = nums2[nums2High--];
//            }
//        }
        return isEven?(array[medianIndex-1]+array[medianIndex])/2.0:array[medianIndex-1];
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{1,3},new int[]{2,4}));
    }
}