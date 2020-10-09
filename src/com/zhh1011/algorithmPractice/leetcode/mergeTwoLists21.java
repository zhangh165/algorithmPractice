package com.zhh1011.algorithmPractice.leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class mergeTwoLists21 {
    static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        int lastValueL1 = getLastNode(l1).val;
        int lastValueL2 = getLastNode(l2).val;
        if(l1.val >= lastValueL2){
            return mergeTwoLists1B2(l2,l1);
        }else if(l2.val >= lastValueL1){
            return mergeTwoLists1B2(l1,l2);
        }else {
            ListNode nextNode1 = l1;
            ListNode nextNode2 = l2;
            int l;
            if(l1.val > l2.val){
                l = l2.val;
                nextNode1 = nextNode1.next;
            }else {
                l = l1.val;
                nextNode2 = nextNode2.next;
            }
            ListNode newListHead = new ListNode(l);
            ListNode nextNodeN = newListHead.next;
            while (nextNode1 != null || nextNode2 != null) {
                if (nextNode1.val < nextNode2.val &&(nextNode1 != null || nextNode2 != null)) {
                    nextNodeN= new ListNode(nextNode1.val);
                    nextNode1 = nextNode1.next;
                }else if(nextNode1.val >= nextNode2.val &&(nextNode1 != null || nextNode2 != null)){
                    nextNodeN= new ListNode(nextNode2.val);
                    nextNode2 = nextNode2.next;
                }else if(nextNode1 == null){
                    nextNodeN= new ListNode(nextNode2.val);
                    nextNode2 = nextNode2.next;
                }else if(nextNode2 == null){
                    nextNodeN= new ListNode(nextNode1.val);
                    nextNode2 = nextNode2.next;
                }
                nextNodeN = nextNodeN.next;
            }
            return  newListHead;
        }
    }
    static ListNode mergeTwoLists1B2(ListNode l1, ListNode l2){
        ListNode lastNode = getLastNode(l1);
        lastNode.next = l2;
        return l1;
    }

    static ListNode getLastNode(ListNode l1){
        ListNode nextNodeL1 = l1;
        while (nextNodeL1.next != null){
            nextNodeL1 = nextNodeL1.next;
        }
        return nextNodeL1;
    }
}

