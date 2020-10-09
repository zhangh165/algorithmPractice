package com.zhh1011.algorithmPractice.leetcode;

public class LT486_PredictTheWinner {
    public static boolean getResult(int[] nums){
//        int i = 0,j = array.length-1;
//        int player1 = 0,player2 = 0;
//        boolean isPlayer1 = true;
//        while(i<j){
//            if(isPlayer1){
//                player1+=array[i] > array[j] ?array[i++]:array[j--];
//                isPlayer1 = false;
//            }else {
//                player2+=array[i] > array[j] ?array[i++]:array[j--];
//                isPlayer1 = true;
//            }
//        }
//        return player1 >= player2;
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public static int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }

    public static void main(String[] args){
        System.out.println(getResult(new int[]{1, 5, 233, 7}));
    }
}
