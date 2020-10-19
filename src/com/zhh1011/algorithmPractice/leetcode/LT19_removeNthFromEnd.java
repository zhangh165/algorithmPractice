package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.ListNode;

/**
 * author: dsa44
 * create time: 2020/10/18 9:28
 */
public class LT19_removeNthFromEnd {
    public static ListNode getResult(ListNode head, int n) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode first = temp,second = temp;
        while(first != null){
            if(n < 0){
                second = second.next;
            }
            first = first.next;
            n--;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.arrayToListNode("1,2".split(","));
        System.out.println(getResult(head,1));
    }
}