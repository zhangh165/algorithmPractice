package com.zhh1011.algorithmPractice.dataStructure;

public class MyLinkedList {
    private Node head;
    private Node[] list = new Node[1000];
    private int size;
    
    public MyLinkedList(int data){
        head = new Node(data);
        size = 1;
    }
    
    public void add(int data,int index){
        Node nextNode = head;
        while (next(nextNode) != null){
            nextNode = next(nextNode);
        }
        list[index] = new Node(data);
        nextNode.setNext(index);
    }
    
    public int seach(int data){
        int count = 0;
        Node nextNode = head;
        if(head.getNext() == data){
            return 0;
        }else {
            while (next(nextNode) != null ) {
                count++;
                nextNode = next(nextNode);
                if(nextNode.getData() == data){
                    return count;
                }
            }
            return -1;
        }
    }
    
    public boolean insert(int index,int data,int next){
        if(index > size()-1 && index < 1){
            return  false;
        }
        if(list[next] != null) {
            return false;
        }

        int count = 0;
        Node newNode = new Node(data);
        list[next] = newNode;
        Node nextNode = head;

        while (next(nextNode) != null){
            if(count == index - 1){
                newNode.setNext(nextNode.getNext());
                nextNode.setNext(next);
                break;
            }
            nextNode = next(nextNode);
            count++;
        }

        getSize();
        return  true;
    }

    public boolean delete(int index){
        if(index >= size() && index<1){
           return false;
        }

        int count = 0;
        Node nextNode = head;
        Node belowNode = null;

        while (next(nextNode) != null){
            if(count == index-1){
                belowNode = nextNode;
                count++;
            }else if(count == index) {
                int temp = belowNode.getNext();
                belowNode.setNext(next(nextNode).getNext());
                list[temp] = null;
                break;
            }else{
                nextNode = next(nextNode);
                count++;
            }
        }
        return true;
    }


    public int size(){
        return size;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("--> HEAD [");
        sb.append(" Data :"+head.getData());
        sb.append(" Next :"+head.getNext());
        sb.append("] \r\n");

        Node nextNode = head;
        int count = 0;
        while (next(nextNode) != null){
            nextNode = next(nextNode);
            count++;
            sb.append("--> "+count+" [");
            sb.append(" Data :"+nextNode.getData());
            sb.append(" Next :"+nextNode.getNext());
            sb.append("] \r\n");
        }

        return sb.toString();
    }
    
    private void getSize(){
        int count = 0;
        Node nextNode = head;
        while (next(nextNode) != null){
            count++;
            nextNode = next(nextNode);
        }
        size = ++count;
    }
    
    private Node next(Node nextNode){
        if(nextNode.getNext() != -1){
            return list[nextNode.getNext()];
        }else {
            return  null;
        }
    }
    
    class Node{
        private int data;
        private int next;

        public Node(int data) {
            this.data = data;
            next = -1;
        }

        public Node(int data, int next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getNext() {
            return next;
        }

        public void setNext(int next) {
            this.next = next;
        }
    }

    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList(5);
        list.add(6,11);
        list.add(7,12);
        list.add(9,18);
        list.add(8,14);
        list.add(10,20);

        list.insert(3,0,25);
        list.delete(3);

        System.out.println(list.toString());
    }
}
