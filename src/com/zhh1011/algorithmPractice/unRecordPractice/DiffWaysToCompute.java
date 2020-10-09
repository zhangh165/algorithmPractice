package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DiffWaysToCompute {
    Stack<Integer> numberStack = new Stack<>();
    Stack<Character> operationStack = new Stack<>();
    List<Integer> numbers = new ArrayList<>();
    List<Character> operations = new ArrayList<>();
    public List<Integer> diffWaysToCompute(String input) {
        int lastIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ( c < '0' || c >'9') {
                int num = Integer.valueOf(input.substring(lastIndex, i));
                lastIndex = i + 1;
                operations.add(c);
                numbers.add(num);
            }
        }
        numbers.add(Integer.valueOf(input.substring(lastIndex, input.length())));

        if(operations.size() == 0) {
            result.add((numbers.get(0)));
            return result;
        }
        if(operations.size() == 1) {
            result.add(caculate(numbers.get(0), numbers.get(1), operations.get(0)));
            return result;
        }
        operationStack.push(operations.get(0));
        numberStack.push(numbers.get(0));

        dfs(1, numbers.get(1), 1);
        return result;
    }
    List<Integer> result = new ArrayList<>();
    // 默认在栈顶，然后2种选择：入栈往下走  或者 和栈顶合并
    void dfs(int numi, int nowNum, int opi) {
        if (opi == operations.size() && numberStack.isEmpty()) {
            result.add(nowNum);
            return ;
        }

        if( opi < operations.size()) {
            // 不合并，往下走
            numberStack.push(nowNum);
            operationStack.push(operations.get(opi));
            dfs(numi + 1, numbers.get(numi + 1), opi + 1);
            numberStack.pop();
            operationStack.pop();
        }

        if (!operationStack.isEmpty()) {
            // 和栈顶合并
            char op = operationStack.pop();
            int lastNum = numberStack.pop();
            int mergeNum = caculate(lastNum, nowNum, op);
            dfs(numi,mergeNum,opi);
            operationStack.push(op);
            numberStack.push(lastNum);
        }
    }
    int caculate(int num1, int num2, char op) {
        switch(op) {
            case '+' : return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1* num2;
        }
        return 0;
    }
}
