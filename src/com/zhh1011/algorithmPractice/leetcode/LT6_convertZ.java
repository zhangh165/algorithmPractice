package com.zhh1011.algorithmPractice.leetcode;

/**
 * author: dsa44
 * create time: 2020/10/9 8:35
 */
public class LT6_convertZ {
    public static String getResult(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0;i < numRows;i++){
            sbs[i] = new StringBuilder();
        }
        int loopNum = numRows*2-2 > 0?numRows*2-2:1;
        for(int i = 0;i < s.length();i+=loopNum){
            int j;
            for(j = 0;j<numRows;j++){
                if(j+i < s.length()){
                    sbs[j].append(s.charAt(j+i));
                }else{
                    break;
                }
            }
            for(int x = numRows-2;j < loopNum;j++,x--){
                if(j+i < s.length()){
                    sbs[x].append(s.charAt(j+i));
                }else{
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder sbSub:sbs){
            sb.append(sbSub.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getResult("AB",1));
    }
}