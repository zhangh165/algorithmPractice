package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.ListNode;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月13日 上午8:32:32
 */
public class LT328_oddEvenList {
	public static ListNode getResult(ListNode head) {
		if(null == head || head.next == null || head.next.next == null) {return head;}
		ListNode oneHead = new ListNode(),
				twoHead = new ListNode();
		ListNode one = head,two = head.next;
		oneHead.next = one;
		twoHead.next = two;
		while(one != null && two != null) {
			one = connect(one, one.next);
			two = connect(two, two.next);
		}
		while(oneHead.next!=null) {
			oneHead = oneHead.next;
		}
		oneHead.next = twoHead.next;
		return head;
	}
	
	private static ListNode connect(ListNode pre,ListNode next) {
		if(null == next) {return null;}
		System.out.println(pre.val+" "+next.val);
		pre.next = next.next;
		return next.next;
	}
	
	public static void main(String[] args) {
		ListNode head = getResult(ListNode.arrayToListNode("1,2,3,4,5".split(",")));
		System.out.println(head);
	}
}
