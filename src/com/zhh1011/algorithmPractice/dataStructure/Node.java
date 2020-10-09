package com.zhh1011.algorithmPractice.dataStructure;

public class Node<T>{
    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private Node<T> next;

    public Node(){}
    public Node(T t){
        data = t;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
        leftNode.setNext(this);
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
        rightNode.setNext(this);
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }
}
