package com.zhh1011.algorithmPractice.jianZhi;


public class JZ_Add {
    public int Add(int a,int b) {
        //a ^ b相当于无进位相加，(a&b)<<1为当前运算的进位，
        //出了第一次为计算答案，其他递归行为皆在计算后续进位过程
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }
}
