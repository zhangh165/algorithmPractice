package com.zhh1011.algorithmPractice.leetcode;
/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月3日 上午8:19:50
 */
public class LT941_validMountainArray {
	public static boolean getResult(int[] A) {
		if(A == null || A.length <= 2 || A[1] <= A[0]){return false;}
        int index = 1;
        while(index < A.length -1){
            if(A[index] == A[index-1]){
                return false;
            }else if(A[index] < A[index-1]){
                break;
            }
            index++;
        }
        while(index < A.length){
            if(A[index] >= A[index-1]){
                return false;
            }
            index++;
        }
        return true;
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(new int[] {0,3,2,1}));
	}
}
