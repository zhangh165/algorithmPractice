package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.ListNode;
/**
 * author: dsa44
 * create time: 2020/10/13 20:10
 * 原题有递归解法、三指针解法
 * 看不自己写得啥
 */
public class LT24_swapPairs {
    public static ListNode getResult(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        ListNode leftHead = left;
        ListNode rightHead = right;
        head = head.next.next;
        int count = 0;
        while(head != null){
            if((count&1)==0){
                left.next = head;
                head = head.next;
                left = left.next;
            }else{
                right.next = head;
                head = head.next;
                right = right.next;
            }
            count++;
        }
        left.next = null;
        right.next = null;
        left = leftHead;
        right = rightHead;
        head = new ListNode();
        ListNode result = head;
        count += 2;
        if((count&1)!=0) count-=1;
        while(count > 0){
            if((count&1)==0 && right!=null){
                head.next = right;
                right = right.next;
                head = head.next;
            }else if(left!=null){
                head.next = left;
                left = left.next;
                head = head.next;
            }
            count--;
        }
        head.next = left;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.arrayToListNode("".split(","));
        head = getResult(head);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}