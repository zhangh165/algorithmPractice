package com.zhh1011.algorithmPractice.jianZhi;

public class JZ_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        char[] anw = new char[str.length()];
        for(int i = 0;i < str.length();i++){
            anw[((i+str.length()-n)%str.length())] = chars[i];
        }
        String re = "";
        for(char c:anw){
            re+=c;
        }
        return re;
    }

    public static void main(String[] args){
        System.out.println(new JZ_LeftRotateString().LeftRotateString("abcXYZdef",3));
    }
}
