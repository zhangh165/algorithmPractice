package com.zhh1011.algorithmPractice.jianZhi;

import com.zhh1011.algorithmPractice.Util.TreeNode;

public class JZ_isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot){
        StringBuilder sb = new StringBuilder();
        inOrder(pRoot,sb);
        String inOrderStr = sb.toString();
        inOrderStr=inOrderStr.replaceAll("#","");
        int i = 0,j = inOrderStr.length()-1;
        while(i<j){
            char left = inOrderStr.charAt(i),
                 right = inOrderStr.charAt(j);
            if(left!=right){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    void inOrder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("#");
            return;
        }
        inOrder(root.left,sb);
        sb.append(root.val);
        inOrder(root.right,sb);
    }
}

