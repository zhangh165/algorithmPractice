package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenerateP {
    private static Map<String,Boolean> map = new HashMap<>();
    private static String[] strings;

    public static void generateP(String str){
        for(char c:str.toCharArray()){
            map.put(c+"",false);
        }
        strings = new String[str.length()];
        generateP(0);
    }

    private static void generateP(int n){
        if(n == strings.length){
            System.out.println(Arrays.toString(strings));
            return;
        }else {
            for(String s:map.keySet()){
                if(!map.get(s)){
                    map.put(s,true);
                    strings[n] = s;
                    generateP(n+1);
                    map.put(s,false);
                }
            }
        }
    }

    public static void main(String[] args){
        generateP("abc");
    }
}
