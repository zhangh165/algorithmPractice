package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * author: dsa44
 * create time: 2020/9/25 20:19
 */
public class LT106_buildTree {
    private static Map<Integer,Integer> map = new HashMap<>();
    private static int[] pOrder;
    public static TreeNode getResult(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        pOrder = postorder;
        TreeNode root = buildTree(0,postorder.length-1,0,inorder.length-1);
        return root;
    }

    private static TreeNode buildTree(int low,int high,int iLow,int iHigh){
        if(low >= high){
            return new TreeNode(pOrder[high]);
        }
        TreeNode root = new TreeNode(pOrder[high]);
        int index = map.get(root.val);
        int leftLength = index - iLow,rightLength = iHigh - index;
        root.left = buildTree(low,low+leftLength-1,iLow,index-1);
        root.right = buildTree(low+leftLength,low+leftLength+rightLength-1,index+1,index+rightLength);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = getResult(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        System.out.println(TreeNode.perOder(root));
    }
}