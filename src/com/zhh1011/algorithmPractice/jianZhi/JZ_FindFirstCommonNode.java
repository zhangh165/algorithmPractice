package com.zhh1011.algorithmPractice.jianZhi;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表公共节点
 * 双指针
 */
public class JZ_FindFirstCommonNode {
    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        while(pHead1!=null){
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            if(!set.contains(pHead2)){
                break;
            }
        }
        return pHead2;
    }
}
