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

    @Override
    public String toString() {
        ListNode quick = this,slow = this;
        while (quick!=null&&quick.next!=null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                ListNode head = this;
                while(head!=slow){
                    head = head.next;
                    slow = slow.next;
                }
                return "cycle list, bad node is "+head.val;
            }
        }
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while(temp!=null){
            sb.append(temp.val+",");
            temp = temp.next;
        }
        return sb.substring(0,sb.length()-1);
    }
}
