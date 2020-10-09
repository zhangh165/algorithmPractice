package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

import java.util.HashSet;
import java.util.Set;

public class HJ10 {
    public static int getResult(String str){
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        for(char c:chars){
            set.add(c);
        }
        return set.size();
    }
}
