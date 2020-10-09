package com.zhh1011.algorithmPractice.unRecordPractice;

public class UpdateMatrix {
    boolean[][] isViewed;
    int[][] next = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
//        int cLength = matrix.length,rLength= matrix[0].length;
//        for(int i=0;i<cLength;i++){
//            for(int j=0;j<rLength;j++){
//                if(matrix[i][j]==0) {
//                    dfs(matrix, i, j, 0);
//                }
//            }
//        }
        isViewed = new boolean[matrix.length][matrix[0].length];
        dfs(matrix,0,0,0);
        return matrix;
    }
    private void dfs(int[][] matrix,int i,int j,int count){
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length){
            return;
        }
        int curNum = matrix[i][j];
        if(curNum>=1){
            count++;
            matrix[i][j] = Math.min(curNum,count);
            for(int[] a:next){
                int iTemp = i+a[0],jTemp = j+a[1];
                if(iTemp<0||iTemp>=matrix.length||jTemp <0||jTemp >=matrix[0].length){
                    continue;
                }
                isViewed[iTemp][jTemp] = true;
                dfs(matrix,iTemp,jTemp,0);
                isViewed[iTemp][jTemp] = false;
            }
        }else if(!isViewed[i][j]){
            isViewed[i][j] = true;
            dfs(matrix,i-1,j,0);
            dfs(matrix,i+1,j,0);
            dfs(matrix,i+1,j,0);
            dfs(matrix,i,j+1,0);
        }
    }

    public static void main(String[] args){

    }

}
