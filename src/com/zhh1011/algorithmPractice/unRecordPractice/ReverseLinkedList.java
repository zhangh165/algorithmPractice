package com.zhh1011.algorithmPractice.unRecordPractice;

public class ReverseLinkedList {
    private static class Node{
        int data;
        Node nextNode = null;

        private Node(int data){
            this.data = data;
        }
    }

    public static Node reverseList(Node root){
        Node head = new Node(-1);
        Node nextNode = root;

        Node temp = null;
        while(nextNode != null){
            temp = head.nextNode;
            head.nextNode = nextNode;
            nextNode = root.nextNode;
            nextNode.nextNode = temp;
        }
        return head.nextNode;
    }
}

