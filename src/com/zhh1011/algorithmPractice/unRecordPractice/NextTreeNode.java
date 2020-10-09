package com.zhh1011.algorithmPractice.unRecordPractice;

import com.zhh1011.algorithmPractice.dataStructure.Node;
import com.zhh1011.algorithmPractice.dataStructure.Tree;

public class NextTreeNode {
    public static void main(String[] args){
        Tree<Integer> linkedTree = new Tree<Integer>(new Integer[]{1,2,3,4,5,6});
        System.out.println(linkedTree.inOrder());

        Node<Integer> targetNode = linkedTree.search(2);
        System.out.println(findNextNode(targetNode).getData());
    }

    static Node<Integer> findNextNode(Node<Integer> target){
        if(target.getRightNode() != null){
            Node<Integer> nextNode = target.getRightNode();

            while(nextNode != null){
                nextNode = nextNode.getLeftNode();
            }
            return nextNode;
        }else {
            while(target.getNext() != null){
                Node<Integer> parent = target.getNext();
                if(parent.getLeftNode() == target){
                    return parent;
                }
                target =target.getNext();
            }
        }
        return null;
    }
}
