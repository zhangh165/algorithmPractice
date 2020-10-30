package com.zhh1011.algorithmPractice.leetcode;

import java.awt.GridBagConstraints;

/**
 * author: dsa44
 * create time: 2020/10/30 7:53
 */
public class LT463_islandPerimeter {
	private static int[][] grid;
	private static int perimeter = 0;
	public static int getResult(int[][] grid) {
		LT463_islandPerimeter.grid = grid;
		for(int i = 0; i < grid.length;i++) {
			for(int j = 0; j < grid[0].length;j++) {
				if(grid[i][j] == 1) {
					perimeter+=dfs(i, j);
				}
			}
		}
		return perimeter;
	}
	
	private static int dfs(int x,int y) {
		if(x >= grid.length 
				|| y >= grid[0].length 
				|| x < 0 
				|| y < 0 
				|| grid[x][y] == 0) {
			return 1;
		}
		if(grid[x][y] == 2) {
			return 0;
		}
		int res = 0;
		grid[x][y] = 2;
		res+=dfs(x-1, y);
		res+=dfs(x, y+1);
		res+=dfs(x+1, y);
		res+=dfs(x, y-1);
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(new int[][] {
			{0,1,0,0},
			{1,1,1,0},
			{0,1,0,0},
			{1,1,0,0}
		}));
	}
}
