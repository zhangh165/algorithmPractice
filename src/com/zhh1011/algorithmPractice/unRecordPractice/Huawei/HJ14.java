package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HJ14 {
    private static List<String> set = new ArrayList<>();
    public static String getResult(){
        Collections.sort(set);
        StringBuilder sb = new StringBuilder();
        for(String temp:set){
            sb.append(temp+"\n");
        }
        return sb.toString();
    }

    public static void inputData(String str){
        set.add(str);
    }
}
