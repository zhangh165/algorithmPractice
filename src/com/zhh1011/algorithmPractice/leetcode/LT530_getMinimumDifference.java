package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.TreeNode;

import java.util.Arrays;

/**
 * author: dsa44
 * create time: 2020/10/12 6:54
 */
public class LT530_getMinimumDifference {
    private static long last = Integer.MAX_VALUE;
    private static long min = Integer.MIN_VALUE;
    public static int getResult(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        last = root.val;
        dfs(root);
        return (int)min;
    }

    private static void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        min = Math.min(min,root.val - last);
        last = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTree("1,null,3,2".split(","));
        System.out.println(getResult(root));
    }
}