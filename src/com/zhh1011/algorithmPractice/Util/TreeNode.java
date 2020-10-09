package com.zhh1011.algorithmPractice.Util;

import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode arrayToTree(String[] nums){
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for(int i = 0; i < treeNodes.length;i++){
            if(!nums[i].equals("null")){
                treeNodes[i] = new TreeNode(Integer.parseInt(nums[i]));
            }else {
                continue;
            }
        }
        for(int i = 0;i < treeNodes.length;i++){
            if((i*2+1) < treeNodes.length && treeNodes[i]!=null) {
                treeNodes[i].left = treeNodes[i * 2 + 1];
                if((i*2+2) < treeNodes.length ){
                    treeNodes[i].right = treeNodes[i * 2 + 2];
                }
            }
        }
        return treeNodes[0];
    }

    public static String perOder(TreeNode root){
        StringBuilder sb = new StringBuilder();
        perOder(root,sb);
        return sb.toString();
    }

    private static void perOder(TreeNode root,StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val+" ");
        perOder(root.left,sb);
        perOder(root.right,sb);
    }
    @Override
    public String toString() {
        return " "+val+" ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}
