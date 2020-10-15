package com.zhh1011.algorithmPractice.leetcode;

/**
 * author: dsa44
 * create time: 2020/10/15 10:42
 */
public class LT116_connect {
    private static Node[] nodes;
    public static Node getResult(Node root) {
        if(null == root){return root;}
        nodes = new Node[100];
        for(int i = 0; i < 100;i++){
            nodes[i] = new Node();
        }
        dfs(root,0);
        return root;
    }

    private static void dfs(Node root,int k){
        if(root == null){return;}
        dfs(root.left,k+1);
        nodes[k].next = root;
        nodes[k] = root;
        dfs(root.right,k+1);
    }

    public static void main(String[] args) {

    }

    private static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}