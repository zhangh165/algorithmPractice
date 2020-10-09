package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_FindNumsAppearOnce{
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            int eor = 0;
            for(int i:array) {
                eor^=i;
            }
            int eor1 = eor;
            int temp = eor&(~eor+1);
            for(int i:array) {
                if((i&temp)==1) {
                    eor^=i;
                }
            }
            num1[0] = eor;
            num2[0] = eor1^eor;
        }
}
