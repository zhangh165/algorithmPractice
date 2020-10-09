package com.zhh1011.algorithmPractice.dataStructure;

import java.util.Stack;

public class Tree<T> {
    private Node<T> root;

    public Tree(T data){
        root = new Node<T>(data);
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Tree(T[] t){
        create(t);
    }

    public void insert(T data){
        Node<T> newNode = insert();
        newNode.setData(data);
    }

    private Node<T> insert(){
        //类DFS搜索空节点添加新值
//        if(nextNode.getLeftNode() == null){
//            nextNode.setLeftNode(new Node<T>());
//            return nextNode.getLeftNode();
//        }else if(nextNode.getRightNode() == null){
//            nextNode.setRightNode(new Node<T>());
//            return nextNode.getRightNode();
//        }else {
//            return insert(nextNode.getLeftNode());
//        }
        //BFS搜索添加新值
        if(root == null){
            root = new Node<T>();
            return root;
        }
        MyQueue<Node<T>> nodeQueue = new MyQueue<Node<T>>();
        Node<T> nextNode = root;
        while (nextNode.getLeftNode() != null && nextNode.getRightNode() != null){
            nodeQueue.push(nextNode.getLeftNode());
            nodeQueue.push(nextNode.getRightNode());
            nextNode = nodeQueue.getFront();
            nodeQueue.pop();
        }
        if(nextNode.getLeftNode() == null){
            nextNode.setLeftNode(new Node<T>());
            return nextNode.getLeftNode();
        }else{
            nextNode.setRightNode(new Node<T>());
            return nextNode.getRightNode();
        }
    }

    public Node search(T data){
        MyQueue<Node<T>> queue = new MyQueue<Node<T>>();
        Node<T> nextNode = null;
        queue.push(root);
        while(!queue.isEmpty()){
            nextNode = queue.getFront();
            queue.pop();
            if(nextNode.getData().equals(data)){
                return nextNode;
            }
            if(nextNode.getLeftNode() != null){
                queue.push(nextNode.getLeftNode());
            }
            if(nextNode.getRightNode() != null){
                queue.push(nextNode.getRightNode());
            }
        }
        return null;
    }


    public void create(T[] datas){
        for (T data:
             datas) {
            insert(data);
        }
    }

    /**
     * 先序遍历
     * @return
     */
    public String perOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        perOrder(stringBuffer,root);
        stringBuffer.append("\r\n");
        perOrder(stringBuffer);
        return stringBuffer.toString();
    }

    /**
     * 递归版本
     * @param stringBuffer
     * @param nextNode
     */
    private void perOrder(StringBuffer stringBuffer,Node<T> nextNode){
        if(null == nextNode){
            return;
        }
        stringBuffer.append(nextNode.getData().toString());
        perOrder(stringBuffer,nextNode.getLeftNode());
        perOrder(stringBuffer,nextNode.getRightNode());
    }

    /**
     * 非递归版本
     * @param stringBuffer
     */
    private void perOrder(StringBuffer stringBuffer){
        Stack<Node<T>> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node<T> node = stack.pop();
            stringBuffer.append(node.getData().toString());
            if(node.getRightNode()!=null){
                stack.add(node.getRightNode());
            }
            if(node.getLeftNode()!=null){
                stack.add(node.getLeftNode());
            }
        }
    }

    /**
     * 中序遍历
     * @return
     */
    public String inOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        inOrder(stringBuffer,root);
        stringBuffer.append("\r\n");
        inOrder(stringBuffer);
        return stringBuffer.toString();
    }

    /**
     * 中序遍历递归版本
     * @param stringBuffer
     * @param nextNode
     */
    private void inOrder(StringBuffer stringBuffer,Node<T> nextNode){
        if(null == nextNode){
            return;
        }
        inOrder(stringBuffer,nextNode.getLeftNode());
        stringBuffer.append(nextNode.getData().toString());
        inOrder(stringBuffer,nextNode.getRightNode());
    }

    /**
     * 中序遍历非递归版本
     * @param stringBuffer
     */
    private void inOrder(StringBuffer stringBuffer){
        Stack<Node<T>> stack = new Stack<>();
       Node<T> temp = root;
        while(!stack.isEmpty()||temp!=null){
            //将当前节点的所有左节点压入栈
            if(temp!=null){
                stack.add(temp);
                temp = temp.getLeftNode();
            //若到达左边界，打印栈顶节点（即左边界，则尝试压入有节点
            }else{
                temp = stack.pop();
                stringBuffer.append(temp.getData().toString());
                temp = temp.getRightNode();
            }
        }
    }

    public String postOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        postOrder(stringBuffer,root);
        stringBuffer.append("\r\n");
        postOrder(stringBuffer);
        return stringBuffer.toString();
    }

    private void postOrder(StringBuffer stringBuffer,Node<T> nextNode){
        if(null == nextNode){
            return;
        }
        postOrder(stringBuffer,nextNode.getLeftNode());
        postOrder(stringBuffer,nextNode.getRightNode());
        stringBuffer.append(nextNode.getData().toString());
    }

    private void postOrder(StringBuffer stringBuffer){
        Stack<Node<T>> stack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node<T> node = stack.pop();
            stringStack.push(node.getData().toString());
            if(node.getLeftNode()!=null){
                stack.push(node.getLeftNode());
            }
            if(node.getRightNode()!=null){
                stack.push(node.getRightNode());
            }
        }
        while(!stringStack.isEmpty()){
            stringBuffer.append(stringStack.pop());
        }
    }

    public String layerOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        layerOrder(stringBuffer);
        return stringBuffer.toString();
    }

    private void layerOrder(StringBuffer stringBuffer){
        MyQueue<Node<T>> nodeQueue = new MyQueue<Node<T>>();
        Node<T> nextNode = root;
        while (nextNode!= null){
            if(nextNode.getLeftNode()!=null) {
                nodeQueue.push(nextNode.getLeftNode());
            }
            if(nextNode.getRightNode()!=null) {
                nodeQueue.push(nextNode.getRightNode());
            }
            stringBuffer.append(nextNode.getData().toString());
            nextNode = nodeQueue.getFront();
            nodeQueue.pop();
        }
    }

    public static void main(String[] args){
        Tree<String> strTree = new Tree<String>("A");
        strTree.create(new String[]{"B","C","D","E","","F"});
        System.out.println("PerOrder");
        System.out.println(strTree.perOrder());
        System.out.println("InOrder");
        System.out.println(strTree.inOrder());
        System.out.println("PostOrder");
        System.out.println(strTree.postOrder());
        System.out.println("BFS LayerOrder");
//        System.out.println(strTree.layerOrder());
    }

}
