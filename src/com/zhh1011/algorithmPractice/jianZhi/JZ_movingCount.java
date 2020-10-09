package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_movingCount {
    private boolean[][] isViewed;
    public int movingCount(int threshold, int rows, int cols){
        isViewed= new boolean[rows][cols];
        return dfs(0,0,threshold,0);
    }

    private int dfs(int i,int j,int threshold,int count){
        if(i==isViewed.length||j==isViewed[0].length||!check(i,j,threshold)||isViewed[i][j]){
            return count;
        }
        isViewed[i][j] = true;
        count++;
        count = dfs(i+1,j,threshold,count);
        count = dfs(i,j+1,threshold,count);
        return count;
    }

    private boolean check(int i,int j,int threshold){
        int sum = 0;
        while (i >0){
            sum+=i%10;
            i/=10;
        }
        while (j >0){
            sum+=j%10;
            j/=10;
        }

        return sum <=threshold;
    }

    public static void main(String[] args){
        System.out.println(new JZ_movingCount().movingCount(15,20,20));
    }
}
