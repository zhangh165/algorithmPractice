package com.zhh1011.algorithmPractice.unRecordPractice;

public class TwoMatrixSearch {
    int[][] a;

    TwoMatrixSearch(int[][] a){
        this.a = a;
    }

    boolean searchNum(int n){
        int rowLength = a.length;
        int colLength = a[0].length;

        int rowIndex = 0;
        int colIndex = colLength - 1;
        while (rowIndex < rowLength && colIndex >= 0) {
            if(a[rowIndex][colIndex] < n){
                rowIndex++;
            }else if(a[rowIndex][colIndex] > n){
                colIndex--;
            }else {
                return true;
            }
        }

        return false;
    }
}
