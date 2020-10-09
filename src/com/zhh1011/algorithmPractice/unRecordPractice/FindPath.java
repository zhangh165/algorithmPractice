package com.zhh1011.algorithmPractice.unRecordPractice;

import com.zhh1011.algorithmPractice.dataStructure.Node;

import java.util.ArrayList;

public class FindPath {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public void findPath(int target, Node<Integer> root){
        findPath(target,root,new ArrayList<Integer>());
    }

    private void findPath(int target,Node<Integer> root,ArrayList<Integer> path){
        if(root == null){
            return;
        }

        target-=root.getData();
        path.add(root.getData());

        if(target==0&&root.getLeftNode()==null&&root.getRightNode()==null){
            result.add(path);
        }else {
            findPath(target,root.getLeftNode(),path);
            findPath(target,root.getRightNode(),path);
        }

    }
}
