package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.ListNode;
/**
 * author: dsa44
 * create time: 2020/10/10 8:56
 */
public class LT142_detectCycle {
    /**
     * 设 环外长度为a，快慢指针相遇时慢指针环内所走距离为b，剩余环内长度为c
     * 有 a+n(b+c)+b
     * 又 快指针所走距离为慢指针的二倍
     * 有 a+n(b+c)+b = 2(a+b)
     * 得 a = (n-1)(b+c)+c
     * 故 令ptr指针指向链表头，并使其与慢指针以相同速率前进
     * 二指针相遇时节点即为环节点入口
     * （慢指针处于b，再转n-1圈后再走c到达入口，ptr则刚好走完a到达入口，二指针相遇）
     * @param head 链表头
     * @return 环入口
     */
    public static ListNode getResult(ListNode head) {
        ListNode slow= head,quick = head;
        while(quick!=null && quick.next!=null){
            quick = quick.next.next;
            slow = slow.next;
            if(slow == quick){
                ListNode ptr = head;
                while(ptr!=slow){
                    ptr= ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}