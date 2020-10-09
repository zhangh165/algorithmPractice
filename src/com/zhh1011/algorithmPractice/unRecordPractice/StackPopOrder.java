package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Stack;

public class StackPopOrder {
    private Stack<Integer> stack = new Stack<Integer>();
    private StringBuffer sb = new StringBuffer();

    public void E(int x){
        stack.push(x);
        sb.append("E");
    }

    public void D(){
        stack.pop();
        sb.append("D");
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int pushI = 0,popI=0;

        while (popI < popA.length){
            if(stack.isEmpty()||stack.peek()!=popA[popI]){
                E(pushA[pushI]);
                pushI++;
            }else {
                D();
                popI++;
            }
        }
        while(popI< popA.length&&!stack.isEmpty()){
            if(stack.peek()!=popA[popI]){
                break;
            }else{
                D();
                popI++;
            }
        }

        return sb.length() == pushA.length*2;
    }
}
