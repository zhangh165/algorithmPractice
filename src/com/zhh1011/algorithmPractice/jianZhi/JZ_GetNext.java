package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            if(pNode.next.right==pNode){
                return pNode.next.next.left == pNode.next?pNode.next.next:null;
            }else {
                return pNode.next;
            }
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}