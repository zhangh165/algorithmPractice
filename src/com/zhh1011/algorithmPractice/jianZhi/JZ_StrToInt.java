package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
                continue;
            if (c < '0' || c > '9')                /* 非法输入 */
                return 0;
            if((Integer.MAX_VALUE-ret*10 >= c-'0')||(isNegative&&Integer.MAX_VALUE-ret*10 >=c-'0'-1)) {
                ret = ret * 10 + (c - '0');
            }else {
                return 0;
            }
        }
        return isNegative ? -ret : ret;
    }

    public static void main(String[] args){
        System.out.println(new JZ_StrToInt().StrToInt("-2147483649"));
    }
}
