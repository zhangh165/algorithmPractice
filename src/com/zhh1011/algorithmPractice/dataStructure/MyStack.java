package com.zhh1011.algorithmPractice.dataStructure;

import java.util.ArrayList;

public class MyStack<T> {
	private ArrayList<T> stack = new ArrayList();
	
	public MyStack() {
	}
	
	public void clear() {
		stack.clear();
	}
	
	public int size() {
		return stack.size();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void push(T value) {
		stack.add(value);
	}
	
	public void pop() {
		stack.remove(stack.size()-1);
	}
	
	public T top() {
		return stack.get(stack.size()-1);
	}
}
