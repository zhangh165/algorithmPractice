package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_replaceSpace {
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            if(c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(replaceSpace("We are happy."));
    }
}
