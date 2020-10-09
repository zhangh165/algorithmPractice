package com.zhh1011.algorithmPractice.unRecordPractice;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int rows  = board.length;
        int cols = board[0].length;
        int[][] copyBoard = new int[rows][cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0; j < cols;j++){
                copyBoard[i][j] = board[i][j];
            }
        }
        for(int i=0;i < rows;i++){
            for(int j = 0; j < cols;j++){
                int oneNum = 0;
                for(int x = -1;x < 2;x++){
                    for(int y = -1;y <2;y++){
                        if(!(x==0&&y==0)){
                            int row = i + x;
                            int col = j + y;
                            if ((row >= 0 && row < rows) && (col >= 0 && col < cols) && (copyBoard[row][col] == 1)) {
                                oneNum+=1;
                            }
                        }
                    }
                }
                switch (copyBoard[i][j]){
                    case 0:
                        if(oneNum == 3){
                            board[i][j] = 1;
                        }
                        break;
                    case 1:
                        if(oneNum < 2 ||oneNum > 3){
                            board[i][j] = 0;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void main(String[] args){
        gameOfLife(new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}});
    }
}
