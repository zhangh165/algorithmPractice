package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for(int i:array){
            count = i==k?count+1:count;
        }
        return count;
    }
}
