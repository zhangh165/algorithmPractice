package com.zhh1011.algorithmPractice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class IsStringValid20 {
    static boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque();

        HashMap map = new HashMap();

        int length = s.length();

        if(length %2 != 0){
            return false;
        }

        for(int i = 0; i < length;i++){
            try {
                switch (s.charAt(i)) {
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if (stack.getFirst() != '(') {
                            return false;
                        } else {
                            stack.pollFirst();
                        }
                        break;
                    case '[':
                        stack.push('[');
                        break;
                    case ']':
                        if (stack.getFirst() != '[') {
                            return false;
                        } else {
                            stack.pollFirst();
                        }
                        break;
                    case '{':
                        stack.push('{');
                        break;
                    case '}':
                        if (stack.getFirst() != '{') {
                            return false;
                        } else {
                            stack.pollFirst();
                        }
                        break;
                    default:
                        return false;
                }
            }catch (Exception e){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("]"));
    }
}
