package com.zhh1011.algorithmPractice.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class InputUtil {
    public static void input() throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str =bf.readLine()) != null){
            int n = Integer.parseInt(str);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
    }
}
