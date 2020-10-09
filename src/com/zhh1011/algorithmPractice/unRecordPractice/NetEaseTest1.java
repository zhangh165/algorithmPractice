package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Scanner;

public class NetEaseTest1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] ints = new int[n];
        while(n-- > 0){
            ints[ints.length-1-n] = input.nextInt();
        }


        int[] as = new int[ints.length];

        for(int i = 0;i < ints.length;i++){
            int j = ints[i];
            String temp = "";
            while(j > 9){
                j-=9;
                temp = 9+temp;
            }
            temp = j+temp;
            as[i]= Integer.parseInt(temp);
        }

        for(int i : as){
            System.out.println(i);
        }
    }
}
