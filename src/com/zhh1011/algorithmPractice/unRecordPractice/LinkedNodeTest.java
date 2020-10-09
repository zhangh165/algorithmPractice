package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Comparator;

public class LinkedNodeTest {
    int val;
    LinkedNodeTest next = null;

    public LinkedNodeTest(int val) {
        this.val = val;
    }
}

class NodeCompereter implements Comparator<LinkedNodeTest> {
    @Override
    public int compare(LinkedNodeTest o1, LinkedNodeTest o2) {
        if(o1.val > o2.val){
            return 1;
        }else if(o1.val == o2.val){
            return 0;
        }else{
            return -1;
        }
    }
}
