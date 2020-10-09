package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.TreeNode;

import java.util.ArrayList;

/**
 * author: dsa44
 * create time: 2020/9/21 11:18
 */
public class LT538_convertBST {
    public static TreeNode getResult(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        dfs(root,nodes);
        int sum = 0;
        for(TreeNode node:nodes){
            int temp = node.val;
            node.val+=sum;
            sum+=temp;
        }
        return root;
    }

    private static void dfs(TreeNode root,ArrayList<TreeNode> list){
        if(root == null){
            return;
        }
        dfs(root.right,list);
        list.add(root);
        dfs(root.left,list);

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTree("5,2,13,1,3,12,14".split(","));
        System.out.println(TreeNode.perOder(root));
        root = getResult(root);
        System.out.println(TreeNode.perOder(root));
    }
}