package com.zhh1011.algorithmPractice.dataStructure;

import java.util.ArrayList;

public class MyQueue <T>{
    private ArrayList<T> queue = new ArrayList();

    public MyQueue(){

    }

    /**
     * 清除队列
     */
    public void clear(){
        queue.clear();
    }

    /**
     * 获取队列大小
     * @return
     */
    public int size(){
        return queue.size();
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    /**
     * 入队一个元素
     * @param element
     */
    public void push(T element){
        queue.add(element);
    }

    /**
     * 出队对头元素
     */
    public void pop(){
        queue.remove(0);
    }

    /**
     * 获取头元素
     * @return
     */
    public T getFront(){
        return queue.get(0);
    }

    /**
     * 获取队尾元素
     * @return
     */
    public T getRear(){
        return queue.get(size()-1);
    }
}
