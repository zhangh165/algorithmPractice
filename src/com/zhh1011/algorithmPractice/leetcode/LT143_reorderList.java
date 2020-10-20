package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.ListNode;

/**
 * author: dsa44
 * create time: 2020/10/20 21:06
 * 快慢指针找中点
 * 反转后半截链表
 * 将后半截嵌到前半截
 */
public class LT143_reorderList {
    public static void getResult(ListNode head) {
        if(head == null || head.next == null || head.next.next==null){return;}
        ListNode quick = head,slow = head;
        ListNode temp = new ListNode();
        while(quick!=null&&quick.next!=null){
            quick = quick.next.next;
            slow = slow.next;
        }
        while(slow!=null){
            quick = slow.next;
            slow.next = temp.next;
            temp.next = slow;
            slow = quick;
        }
        quick = temp.next;
        while(quick!=null&&head!=null){
            slow = head.next;
            head.next = quick;
            head = slow;
            slow = quick.next;
            quick.next = head;
            quick = slow;
        }
        if(head!=null){head.next = null;}
    }

    public static void main(String[] args) {
        ListNode head = ListNode.arrayToListNode("1,2,3,4,5,6".split(","));
        getResult(head);
        System.out.println(head.toString());
    }
}