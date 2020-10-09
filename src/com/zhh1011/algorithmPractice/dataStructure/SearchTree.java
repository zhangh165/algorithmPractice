package com.zhh1011.algorithmPractice.dataStructure;

import java.util.Arrays;

public class SearchTree{
    private Node<Integer> root;

    public SearchTree(int data){
        root = new Node<Integer>(data);
    }

    public SearchTree(int[] array){
        root = new Node<Integer>();
        create(array);
    }

    public void insert(int data){
        insert(root,data);
    }

    private void insert(Node<Integer> nextNode,int data){
        if(data < nextNode.getData()){
            if (nextNode.getLeftNode() == null){
                nextNode.setLeftNode(new Node<Integer>(data));
            }else {
                insert(nextNode.getLeftNode(),data);
            }
        }else {
            if (nextNode.getRightNode() == null){
                nextNode.setRightNode(new Node<Integer>(data));
            }else {
                insert(nextNode.getRightNode(),data);
            }
        }
    }

    public boolean search(int data){
        return search(root,data);
    }

    private boolean search(Node<Integer> nextNode,int data){
        if(data == nextNode.getData()){
            return true;
        }

        if(data < nextNode.getData()){
            if (nextNode.getLeftNode() == null){
                return false;
            }else {
                return search(nextNode.getLeftNode(),data);
            }
        }else {
            if (nextNode.getRightNode() == null){
                return false;
            }else {
                return search(nextNode.getRightNode(),data);
            }
        }
    }

    public boolean delete(int data){
        Node<Integer> curNode = delSearch(root,data);



        if(null == curNode){
            return false;
        }else {
            Node<Integer> indeedNode = delete(curNode);
            if(indeedNode == curNode){
                curNode.setData(null);
                return true;
            }else {
                curNode.setData(indeedNode.getData());
                indeedNode.setData(null);
                return true;
            }
        }
    }

    private Node<Integer> delete(Node<Integer> nextNode){
        if(nextNode.getLeftNode() != null){
            while (nextNode.getRightNode() != null){
                nextNode = nextNode.getRightNode();
            }
            return nextNode;
        }else if(nextNode.getRightNode() != null){
            while (nextNode.getLeftNode() != null){
                nextNode = nextNode.getLeftNode();
            }
            return nextNode;
        }else {
            return null;
        }
    }

    private Node<Integer> delSearch(Node<Integer> nextNode,int data) {
        if (data == nextNode.getData()) {
            return nextNode;
        }

        if (data < nextNode.getData()) {
            if (nextNode.getLeftNode() == null) {
                return null;
            } else {
                return delSearch(nextNode.getLeftNode(), data);
            }
        } else {
            if (nextNode.getRightNode() == null) {
                return null;
            } else {
                return delSearch(nextNode.getRightNode(), data);
            }
        }
    }

    public void create(int[] array){
        root.setData(array[0]);

        array = Arrays.copyOfRange(array,1,array.length);

        for (int a:
             array) {
            insert(a);
        }
    }

    public String perOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        perOrder(stringBuffer,root);
        return stringBuffer.toString();
    }

    private void perOrder(StringBuffer stringBuffer,Node<Integer> nextNode){
        if(null == nextNode){
            return;
        }
        stringBuffer.append(nextNode.getData().toString());
        perOrder(stringBuffer,nextNode.getLeftNode());
        perOrder(stringBuffer,nextNode.getRightNode());
    }

    public String inOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        inOrder(stringBuffer,root);
        return stringBuffer.toString();
    }

    private void inOrder(StringBuffer stringBuffer,Node<Integer> nextNode){
        if(null == nextNode){
            return;
        }
        inOrder(stringBuffer,nextNode.getLeftNode());
        stringBuffer.append(nextNode.getData() == null ? "":nextNode.getData().toString());
        inOrder(stringBuffer,nextNode.getRightNode());
    }

    public static void main(String[] args){
        int[] array = new int[]{5,2,4,8,3,7,9,6,1};
        SearchTree searchTree = new SearchTree(array);
        System.out.println(searchTree.inOrder());
        System.out.println(searchTree.perOrder());
//        System.out.println(searchTree.search(1));
//        searchTree.delete(5);
//        System.out.println(searchTree.inOrder());

    }

}
