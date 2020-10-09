package com.zhh1011.algorithmPractice.dataStructure;

import java.util.Arrays;

/**
 *
 * 二叉平衡树
 * LL型 对根节点（根平衡值等于2，左子树平衡值为1）做右旋操作
 * LR型 先对根节点（根平衡值为2，左节点平衡值为-1）左节点做左旋操作，再对根节点做右旋操作
 * RR型 对根节点（根平衡值等于2，右节点平衡值值为1）做左旋操作
 * RL型 先对根节点（根平衡值等于2，左节点平衡值值为-1）右节点做右旋操作，再对根节点做左旋操作
 * LL--> root 2,root->left 1 --> R
 * LR--> root 2,root->left -1 --> LR
 * RR--> root 2,root->right 1 --> L
 * RL--> root 2,root->right -1 --> RL
 */
public class AVLTest {
    Node0 root;

    public AVLTest(int data) {
        this.root = new Node0(data);
    }

    public AVLTest(int[] array){
        create(array);
    }
    private void create(int[] array){
        root = new Node0(array[0]);
        for(int i:Arrays.copyOfRange(array,1,array.length)){
            insert(i);
        }
    }

    public boolean search(int data){
        return search(root,data);
    }

    private boolean search(Node0 nextNode,int data){
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

    public void insert(int data){
        insert(root,data);
        System.out.println(perOrder());
        System.out.println(inOrder());
        System.out.println(postOrder());
        System.out.println("-->next");
    }

    private void insert(Node0 nextNode,int data){
        if(data < nextNode.getData()){
            if (nextNode.getLeftNode() == null){
                nextNode.setLeftNode(new Node0(data));
                nextNode.setHeight();
            }else {
                insert(nextNode.getLeftNode(),data);
                nextNode.setHeight();
                if(nextNode.getBalanceFactor() == 2){
                    if(nextNode.getLeftNode().getBalanceFactor() == 1){
                        R(nextNode);
                    }else if(nextNode.getLeftNode().getBalanceFactor() == -1){
                        L(nextNode.getLeftNode());
                        R(nextNode);
                    }
                }
            }
        }else {
            if (nextNode.getRightNode() == null){
                nextNode.setRightNode(new Node0(data));
                nextNode.setHeight();
            }else {
                insert(nextNode.getRightNode(),data);
                nextNode.setHeight();
                if(nextNode.getBalanceFactor() == 2){
                    if(nextNode.getBalanceFactor() == -1){
                        L(nextNode);
                    }else if(nextNode.getRightNode().getBalanceFactor() == 1){
                        R(nextNode.getRightNode());
                        L(nextNode);
                    }
                }
            }
        }
    }

    private void  L(Node0 root0){
        //左旋
        Node0 temp = root.getRightNode();
        root0.setLeftNode(temp.getLeftNode());
        temp.setLeftNode(root0);
        //更新高度
        temp.setHeight();
        root0.setHeight();
        //替换根节点
        updateRoot(root0,temp);
    }

    private void R(Node0 root0){
        //右旋
        Node0 temp = root0.getLeftNode();
        root0.setRightNode(temp.getRightNode());
        temp.setRightNode(root0);
        //更新高度
        temp.setHeight();
        root0.setHeight();
        //替换根节点
        updateRoot(root0,temp);
    }

    private void updateRoot(Node0 root0,Node0 temp){
        if(root0 == root){
            this.root = temp;
        }else {
            Node0 parent = root0.getParent();
            if(parent.getLeftNode() == root0){
                parent.setLeftNode(temp);
            }else {
                parent.setRightNode(temp);
            }
        }
    }

    public String perOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        perOrder(stringBuffer,root);
        return stringBuffer.toString();
    }

    private void perOrder(StringBuffer stringBuffer,Node0 nextNode){
        if(null == nextNode){
            return;
        }
        stringBuffer.append(nextNode.toString());
        perOrder(stringBuffer,nextNode.getLeftNode());
        perOrder(stringBuffer,nextNode.getRightNode());
    }

    public String inOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        inOrder(stringBuffer,root);
        return stringBuffer.toString();
    }

    private void inOrder(StringBuffer stringBuffer,Node0 nextNode){
        if(null == nextNode){
            return;
        }
        inOrder(stringBuffer,nextNode.getLeftNode());
        stringBuffer.append(nextNode.toString());
        inOrder(stringBuffer,nextNode.getRightNode());
    }

    public String postOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        postOrder(stringBuffer,root);
        return stringBuffer.toString();
    }

    private void postOrder(StringBuffer stringBuffer,Node0 nextNode){
        if(null == nextNode){
            return;
        }
        postOrder(stringBuffer,nextNode.getLeftNode());
        postOrder(stringBuffer,nextNode.getRightNode());
        stringBuffer.append(nextNode.toString());
    }

    public String layerOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        layerOrder(stringBuffer);
        return stringBuffer.toString();
    }

    private void layerOrder(StringBuffer stringBuffer){
        MyQueue<Node0> nodeQueue = new MyQueue<Node0>();
        Node0 nextNode = root;
        while (nextNode!= null){
            nodeQueue.push(nextNode.getLeftNode());
            nodeQueue.push(nextNode.getRightNode());
            stringBuffer.append(nextNode.toString());
            nextNode = nodeQueue.getFront();
            nodeQueue.pop();
        }
    }

    public static void main(String[] args){
        AVLTest test = new AVLTest(new int[]{5,4,2,8,3,7,9,6,1});
    }
}

class Node0{
    private int data,height;

    private Node0 leftNode,rightNode,parent;

    public Node0(){
        height = 1;
    }

    public Node0(int data) {
        this();
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight() {
        this.height = Math.max(leftNode == null?0:leftNode.getHeight(),rightNode == null?0:rightNode.getHeight())+1;
    }

    public int getBalanceFactor(){
        return  (leftNode == null?0:leftNode.getHeight()) - (rightNode == null?0:rightNode.getHeight());
    }

    public Node0 getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node0 leftNode) {
        leftNode.setParent(this);
        this.leftNode = leftNode;
    }

    public Node0 getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node0 rightNode) {
        rightNode.setParent(this);
        this.rightNode = rightNode;
    }

    public Node0 getParent() {
        return parent;
    }

    public void setParent(Node0 parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "["+data+","+getBalanceFactor()+"]";
    }
}
