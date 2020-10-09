package com.zhh1011.algorithmPractice.unRecordPractice;

/**
 * lc mst 01.07 旋转矩阵
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int topX = 0,topY = 0;
        int buttomX = matrix.length-1,buttomY = matrix[0].length-1;
        while(topX < buttomX){
            for(int i = 0;i<buttomX-topX;i++){
                int temp = matrix[topX][topY+i];
                matrix[topX][topY+i] = matrix[buttomX-i][topY];
                matrix[buttomX-i][topY] = matrix[buttomX][buttomY-i];
                matrix[buttomX][buttomY-i] = matrix[topX+i][buttomY];
                matrix[topX+i][buttomY] = temp;
            }
            topX++;
            topY++;
            buttomX--;
            buttomY--;
        }
    }

    private static void printMatrix(int[][] a){
        for(int[] ar:a){
            for(int i:ar){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Rotate rotate = new Rotate();
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        printMatrix(a);
        rotate.rotate(a);
        System.out.println();
        printMatrix(a);
    }
}
