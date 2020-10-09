package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.TreeNode;

public class LT98_isValidBST {
    public static boolean getResult(TreeNode root){
        return helper(root);
    }

    private static boolean helper(TreeNode node){
        if(node == null){
            return true;
        }
        else if((node.left != null&&node.left.val > node.val )||
                (node.right != null&&node.right.val < node.val)){
            return false;
        }else {
            return helper(node.left) && helper(node.right);
        }
    }
}
