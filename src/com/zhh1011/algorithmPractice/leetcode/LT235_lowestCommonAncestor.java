package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.TreeNode;


/**
 * author: dsa44
 * create time: 2020/9/27 10:56
 */
public class LT235_lowestCommonAncestor {
    private static int[] pq = new int[2];
    private static boolean findOne = false;
    public static TreeNode getResult(TreeNode root, TreeNode p, TreeNode q) {
        pq[0] = p.val;
        pq[1] = q.val;
        return dfs(root);
    }

    private static TreeNode dfs(TreeNode root){
        if(root.val > pq[0] && root.val >pq[1]){
            return dfs(root.left);
        }else if(root.val < pq[0] && root.val < pq[1]){
            return dfs(root.right);
        }else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTree("6,2,8,0,4,7,9,null,null,3,5".split(","));
        System.out.println(getResult(root,new TreeNode(2),new TreeNode(4)));
    }
}