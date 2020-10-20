package com.zhh1011.algorithmPractice.unRecordPractice;

public class BinTree {
    public String perOrder(TreeNode root){
        StringBuilder sb = new StringBuilder();
        perOrderHelper(sb,root);
        return sb.toString().substring(0,sb.length()-1);
    }

    private void perOrderHelper(StringBuilder sb,TreeNode root){
        if(root == null){return; }
        sb.append(root.val+",");
        perOrderHelper(sb,root.left);
        perOrderHelper(sb,root.right);
    }

    public String midOrder(TreeNode root){
        StringBuilder sb = new StringBuilder();
        midOrderHelper(sb,root);
        return sb.toString().substring(0,sb.length()-1);
    }

    private void midOrderHelper(StringBuilder sb,TreeNode root){
        if(root == null){return; }
        midOrderHelper(sb,root.left);
        sb.append(root.val+",");
        midOrderHelper(sb,root.right);
    }

    public String afterOrder(TreeNode root){
        StringBuilder sb = new StringBuilder();
        afterOrderHelper(sb,root);
        return sb.toString().substring(0,sb.length()-1);
    }

    private void afterOrderHelper(StringBuilder sb,TreeNode root){
        if(root == null){return; }
        perOrderHelper(sb,root.left);
        perOrderHelper(sb,root.right);
        sb.append(root.val+",");
    }
}

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
