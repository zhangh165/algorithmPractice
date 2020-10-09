package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ37_tuzi {
    public static void getDeal(int num){
        int old = 1,young = 0,m1 = 0,m2=0;
        for(int i = 0; i < num;i++){
            young = old;
            old +=m2;
            m2 = m1;
            m1 = young;
        }
        System.out.println(old);
    }
}
