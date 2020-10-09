package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.*;

public class Test {
    public static int deal(String[] s1,String[] s2){
        Set<String> strSet = new HashSet<String>();
        for(String str:s1){
            strSet.add(str);
        }
        int count = 0;
        Set<String> strings = new HashSet<String>();
        for(String str:s2){
            if(strSet.contains(str)){
                strings.add(str);
            }
            if(strings.size() == s1.length){
                strings.clear();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s1 = new String[n];
        String x = null;
        x = sc.nextLine();
        for(int i = 0; i < n; i++){
            x = sc.nextLine();
            s1[i]=x;
        }
        System.out.println(Arrays.toString(s1));
        int m = sc.nextInt();
        String[] s2 = new String[m];
        x = null;
        for(int i = 0; i < m; i++){
            x = sc.nextLine();
            s2[i]=x;
        }
        System.out.println(Arrays.toString(s2));
        System.out.println(deal(s1,s2));
    }

}
