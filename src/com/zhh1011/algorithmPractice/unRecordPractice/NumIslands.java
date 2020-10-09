package com.zhh1011.algorithmPractice.unRecordPractice;

public class NumIslands {
    int count = 0;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i,int j,char[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j] ='0';
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
    }
    public static void main(String[] args){
        System.out.println(new NumIslands().numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
    }
}
