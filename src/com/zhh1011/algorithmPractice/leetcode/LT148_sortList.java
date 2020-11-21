package com.zhh1011.algorithmPractice.leetcode;

import java.util.Comparator;

import com.zhh1011.algorithmPractice.Util.ListNode;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年11月21日 上午11:36:42
 */
public class LT148_sortList {
	private static Comparator<ListNode> comparator = (x,y)->{
		if(x == null){
            return 1;
        }else if(y == null){
            return -1;
        }else {
            return y.val-x.val;
        }
	};
	public static ListNode getResult(ListNode head) {
		return sort(head);
	}
	
	private static ListNode sort(ListNode head) {
	if(null == head ||head.next == null) {return head;}
		ListNode above = new ListNode(Integer.MIN_VALUE),
				below = new ListNode(Integer.MIN_VALUE),
				aboveTemp = above;
		ListNode temp = head.next,tempNext = null,tempHead = null;
		//按头节点分大小
		//above表示在头节点之前，比头节点小
		//below表示在头节点之后，比头节点大
		while(temp != null) {
			tempNext = temp.next;
			if(comparator.compare(temp,head) >0) {
				tempHead = above;
			}else {
				tempHead = below;
			}
			temp.next = tempHead.next;
			tempHead.next = temp;
			temp = tempNext;
		}
		//递归排序
		aboveTemp.next = sort(aboveTemp.next);
		below.next = sort(below.next);
		//遍历到上半部的最后一个节点并链接头节点
		if(aboveTemp.next != null) {
			above = aboveTemp.next;
			while(above.next!=null) {
				above = above.next;
			}
			above.next = head;
		}else {
			aboveTemp.next = head;
		}
		//链接下半部分
		head.next = below.next;
		return aboveTemp.next;	
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(ListNode.arrayToListNode("-1,5,3,4,0".split(","))));
	}
}
