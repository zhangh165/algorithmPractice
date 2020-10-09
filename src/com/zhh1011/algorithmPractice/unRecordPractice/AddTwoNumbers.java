package com.zhh1011.algorithmPractice.unRecordPractice;

import com.zhh1011.algorithmPractice.Util.ListNode;
import com.zhh1011.algorithmPractice.Util.Tool;

import java.util.LinkedList;
import java.util.Stack;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> dq = new LinkedList<>();
        ListNode h1 = l1,
                h2 = l2;
        dq.addFirst(null);
        while(l1!=null){
            dq.addFirst(l1);
            l1= l1.next;
        }
        while(l2!=null){
            dq.addLast(l2);
            l2= l2.next;
        }

        Stack<Integer> stack = new Stack<>();
        int plusOne = 0;
        while(!dq.isEmpty()){
            ListNode left = dq.pollFirst();
            ListNode right = dq.pollLast();

            if(left!=null&&right!=null){
                int sum = left.val+right.val+plusOne;
                stack.push(sum>9?sum%10:sum);
                plusOne = sum/10;
            }else if(dq.isEmpty()&&right==null&&left==null){
            }else{
                int sum = (left==null?right.val:left.val)+plusOne;
                stack.push(sum%10);
                plusOne = sum/10;
            }
        }
        if(plusOne!=0){
            stack.push(plusOne);
        }
        ListNode head = new ListNode(-1);
        ListNode headTemp = head;
        while(!stack.isEmpty()){
            ListNode temp = new ListNode(stack.pop());
            head.next = temp;
            head = head.next;
        }
        return headTemp.next;
    }

    public static void main(String[] args){
        ListNode t1 = Tool.stringToListNode("[1]");
        ListNode t2 = Tool.stringToListNode("[9,9,9]");
        System.out.println(Tool.listNodeToString(new AddTwoNumbers().addTwoNumbers(t1,t2)));
    }
}

