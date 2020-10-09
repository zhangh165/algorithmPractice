package com.zhh1011.algorithmPractice.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * author: dsa44
 * create time: 2020/9/28 10:56
 */
public class LT117_connect {
    public static Node getResult(Node root) {
        List<Node> temp = new LinkedList<>();
        temp.add(root);
        bfs(temp);
        return root;
    }

    private static void bfs(List<Node> list){
        if(list.size() == 0){
            return;
        }
        List<Node> temp = new LinkedList<>();
        for(int i = 0;i < list.size()-1;i++){
            list.get(i).next = list.get(i+1);
        }
        for(Node node:list){
            if(node.left!=null) temp.add(node.left);
            if(node.right!=null) temp.add(node.right);
        }
        bfs(temp);
    }

    public static void main(String[] args) {
        Node root = Node.arrayToTree("1,2,3,4,5,null,7".split(","));
        getResult(root);
        System.out.println(root);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {

        return Objects.hash(val, left, right, next);
    }

    public static Node arrayToTree(String[] nums){
        Node[] treeNodes = new Node[nums.length];
        for(int i = 0; i < treeNodes.length;i++){
            if(!nums[i].equals("null")){
                treeNodes[i] = new Node(Integer.parseInt(nums[i]));
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

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}'+
                "\n";
    }
}