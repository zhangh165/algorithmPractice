package com.zhh1011.algorithmPractice.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(){}

    /**
     * 生成一个链表
     * @param array 建议这样产生参数 "1,2,3,4,5".split(",")
     * @return  返回链表头
     */
    public static ListNode arrayToListNode(String[] array){
        if(null == array|| array.length == 0){
            return null;
        }
        try {
            List<Integer> list = Arrays.stream(array)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<ListNode> result = list.stream()
                    .map(ListNode::new)
                    .collect(Collectors.toList());
            for (int i = 0; i < result.size() - 1; i++) {
                result.get(i).next = result.get(i + 1);
            }
            return result.get(0);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
