package com.zhh1011.algorithmPractice.unRecordPractice;

public class LCS {
    private static int LCSDP(int[] a,int[] b){
        int[][] dp = new int[a.length+1][b.length+1];
        for(int i = 1; i < b.length;i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < a.length;i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < a.length;i++){
            for(int j = 1; j < b.length;j++){
                if(a[i] == b[j]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[a.length-1][b.length-1];
    }

    private static boolean LCS(int[] a,int[] b){
        int i,j;
        for(i = 0,j = 0;j < b.length;j++){
            if(i < a.length &&a[i] == b[j] ){
                i++;
            }
        }

        return i == a.length;
    }

    public static void main(String[] args){
        System.out.println(LCSDP(new int[]{-1,5,3,2,6,7},new int[]{-1,1,5,2,3,2,6,7,5,8,9}));
        //System.out.println(LCS(new int[]{-1,5,3,2,6,7},new int[]{-1,1,5,2,3,2,6,7,5,8,9}));
    }
}
