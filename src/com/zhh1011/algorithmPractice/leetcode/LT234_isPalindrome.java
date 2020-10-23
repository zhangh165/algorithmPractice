package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.ListNode;

/**
 * author: dsa44
 * create time: 2020/10/23 9:44
 */
public class LT234_isPalindrome {
    public static boolean getResult(ListNode head) {
        if(null == head||head.next == null){return false;}
        ListNode quick = head,slow = head;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode demmy = new ListNode(-1),midNode = slow;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = demmy.next;
            demmy.next = slow;
            slow = temp;
        }
        slow = demmy.next;
        while(slow!=null){
            if(head.val!=slow.val){
                return false;
            }else{
                head = head.next;
                slow = slow.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getResult(ListNode.arrayToListNode("1,1".split(","))));
    }
}