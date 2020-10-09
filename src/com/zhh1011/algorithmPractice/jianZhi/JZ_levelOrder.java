package com.zhh1011.algorithmPractice.jianZhi;

import com.zhh1011.algorithmPractice.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ_levelOrder {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(pRoot != null) queue.add(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = queue.size();i>0;i--){
                pRoot = queue.poll();
                temp.add(pRoot.val);
                if(pRoot.left != null) queue.add(pRoot.left);
                if(pRoot.right != null) queue.add(pRoot.right);
            }
            result.add(temp);
        }

        return result;
    }
}
