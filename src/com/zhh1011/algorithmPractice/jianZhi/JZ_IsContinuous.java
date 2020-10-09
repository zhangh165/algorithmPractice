package com.zhh1011.algorithmPractice.jianZhi;

import java.util.Arrays;

public class JZ_IsContinuous {
    public boolean isContinuous(int [] numbers) {
        Arrays.sort(numbers);
        int jokerNum = 0;
        int i = 0;
        while (i < numbers.length){
            if(numbers[i]==0){
                jokerNum++;
            }else{
                break;
            }
            i++;
        }
        for(i = jokerNum;i<numbers.length-1;i++){
            if (numbers[i + 1] == numbers[i])
                return false;
            jokerNum -= numbers[i + 1] - numbers[i] - 1;
        }
        return jokerNum>=0;
    }

    public static void main(String[] args){
        System.out.println(new JZ_IsContinuous().isContinuous(new int[]{0,0,0,1,5}));
    }
}
