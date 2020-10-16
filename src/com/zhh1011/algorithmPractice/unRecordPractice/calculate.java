package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: dsa44
 * create time: 2020/10/16 13:47
 * 杨辉三角
 */
public class calculate {
    public static String[] getResult(int N) {
        List<List<Long>> list = new ArrayList<>();
        String[] result = new String[N];
        list.add(Arrays.stream(new long[]{1}).boxed().collect(Collectors.toList()));
        for(int i = 1;i < N;i++){
            List<Long> temp = new ArrayList<>();
            for(int j = 0;j <= i;j++){
                if(j == 0 || j == i){
                    temp.add(1l);
                }else {
                    List<Long> uper = list.get(i-1);
                    temp.add(uper.get(j-1)+uper.get(j));
                }
            }
            list.add(temp);
        }

        for(int i =0;i < N;i++){
            StringBuilder sb = new StringBuilder();
            for(Long j:list.get(i)){
                sb.append(j+" ");
            }
            result[i] = sb.toString().substring(0,sb.length()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getResult(66)));
    }
}