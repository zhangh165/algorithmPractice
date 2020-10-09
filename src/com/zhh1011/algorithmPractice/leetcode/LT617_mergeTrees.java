package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.TreeNode;
/**
 * author: dsa44
 * create time: 2020/9/23 10:35
 */
public class LT617_mergeTrees {
    public static TreeNode getResult(TreeNode root1,TreeNode root2) {
        root1 = dfs(root1,root2);
        return root1;
    }

    private static TreeNode dfs(TreeNode root1,TreeNode root2){
        if(root1 == null){
            if(root2 == null){
                return null;
            }else {
                return root2;
            }
        }else {
            if(root2 != null){
                root1.val+=root2.val;
                root1.left = dfs(root1.left,root2.left);
                root1.right = dfs(root1.right,root2.right);
                return root1;
            }else {
                return root1;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = getResult(
                TreeNode.arrayToTree("1,3,2,5".split(",")),
                TreeNode.arrayToTree("2,1,3,null,4,null,7".split(","))
        );
        System.out.println(TreeNode.perOder(root));
    }
}