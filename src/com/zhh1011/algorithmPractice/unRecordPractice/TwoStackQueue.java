package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public TwoStackQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }else if(!inStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
         return -1;
    }
}
