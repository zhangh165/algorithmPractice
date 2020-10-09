package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HJ50_calculate {
    private Stack<String> optr = new Stack<>();
    private Stack<Double> opnd = new Stack<>();
    private StringBuilder sb = new StringBuilder();

    private Map<String,Integer> map = new HashMap<String, Integer>();
    //初始化操作符优先级
    {
        map.put("*", 1);
        map.put("/", 1);
        map.put("+", 0);
        map.put("-", 0);
        map.put("(", 0);
        map.put("[", 0);
        map.put("{", 0);
    }

    public int calculate(String str){
        char[] array = str.toCharArray();
        String number = "";
        for(int i = 0; i < array.length;i++){
            char c = array[i];
            if(c >= '0' && c <= '9'){
                number+=c;
                continue;
            }else {
                opnd.push(Double.parseDouble(number));
                number = "";

                if (optr.isEmpty()) {
                    optr.push(c + "");
                } else if(c == ')'||c == ']'||c == '}'){
                    optr.pop();
                }else if(c == ' '){

                }
            }
        }
        return 0;
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
