package com.zhh1011.algorithmPractice.unRecordPractice;

import com.zhh1011.algorithmPractice.dataStructure.MyStack;

import java.util.HashMap;
import java.util.Map;

/**
 * 中缀表达式转后缀表达式并进行计算
 * @author zhangh165
 */
public class SimpleCalculator {
	private MyStack<String> stack = new MyStack<String>();
	private StringBuffer sb = new StringBuffer();
	private Map<String,Integer> map = new HashMap<String, Integer>();
	//初始化操作符优先级
	{
		map.put("*", 1);
		map.put("/", 1);
		map.put("+", 0);
		map.put("-", 0);
	}
	
	public SimpleCalculator(){
	}
	
	public void read(String f) {
		char[] chars = f.toCharArray();

		//空格隔开输出
		String number = " ";
		//遍历输入字符
		for(char e:chars) {
			//读取数字
			if(e>='0'&&e<='9') {
				number += e;
				continue;
			}else {
				sb.append(number);
				number = " ";
			}
			//读取操作符
			//如果读入操作符的优先级比栈顶操作符优先级高，或者栈为空，则将操作符压入栈中
			if(stack.isEmpty() || map.get(""+e) > map.get(stack.top())) {
				stack.push(""+e);
			//否则将栈中操作符弹出（输出），直到栈顶操作符优先级低于读入操作符或栈空为止
			}else {
				while(!stack.isEmpty() && map.get(""+e) <= map.get(stack.top())) {
					sb.append(" "+stack.top());
					stack.pop();
				}
				stack.push(""+e);
			}
		}
		//输出最后一个数字
		sb.append(number);
		//将栈中剩余操作符出栈
		while(!stack.isEmpty()) {
			sb.append(" "+stack.top());
			stack.pop();
		}
		//清栈
		stack.clear();
	}
	
	public Double calculateValue() {
		MyStack<Double> number = new MyStack<Double>();
		
		String[] sa = sb.toString().split(" ");
		for(String str: sa) {
			if(str==null ||str.equals("")) {
				continue;
			}
			//若不为操作符（则为数字）
			if(!isCaculate(str)) {
				//向数字栈中压入数字
				number.push(Double.parseDouble(str));
			}else {
				//若为操作符
				//弹出栈中两数字进行运算
				Double x = number.top();
				number.pop();
				Double y = number.top();
				number.pop();
				//将结果压入栈中
				number.push(getResult(y,x,str));

				System.out.println("--> "+y+" "+str+" "+x+" = "+getResult(y,x,str));
			}
		}
		//输出栈顶结果
		return number.top();
	}
	
	public String write() {
		return sb.toString();
	}
	
	private boolean isCaculate(String str) {
		return str.contains("*")||str.contains("/")||str.contains("+")||str.contains("-");
	}
	
	private Double getResult(Double x,Double y,String ca) {
		char c = ca.charAt(0);
		switch(c) {
			case '*': return x*y;
			case '/': return x/y;
			case '+': return x+y;
			case '-': return x-y;
			default: return 0.0;
		}
	}
}
