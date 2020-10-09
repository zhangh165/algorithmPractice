package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;

public class FindContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0,si = 0;
        while(gi<g.length&&si<s.length){
            if(g[gi]<=s[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args){
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }
}
