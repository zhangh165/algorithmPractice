package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ53_yangHuiSanJiao {
    public static int getResult(int n){
        if( n < 3){
            return -1;
        }else if(n%2 == 1){
            return 1;
        }else {
            if(n%4 == 0){
                return 3;
            }else {
                return 4;
            }
        }
    }
}
