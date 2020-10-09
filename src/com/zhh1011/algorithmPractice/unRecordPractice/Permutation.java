package com.zhh1011.algorithmPractice.unRecordPractice;


import java.util.*;

public class Permutation {
    public static ArrayList<String> Permutation(String str) {
        return Permutation(str.toCharArray());
    }

    public static ArrayList<String> Permutation(char[] chars) {
        ArrayList<String> list = new ArrayList<String>();
        if(chars.length >1) {
            list = Permutation(Arrays.copyOfRange(chars, 1, chars.length));
        }else {
            list.add(chars[0]+"");
            return list;
        }
        Set<String> set = new HashSet<String>();
        for(String s:list){
//            list1.add(chars[0]+s);
//            list1.add(s+chars[0]);
            char[] chars1 = s.toCharArray();
            for(int i=0;i< chars1.length+1;i++){
              set.add(
                      charArray2String(Arrays.copyOfRange(chars1,0,i))+
                      chars[0]+
                      charArray2String(Arrays.copyOfRange(chars1,i,chars1.length))
              );
            }
        }
        ArrayList<String> list1 = new ArrayList<String>();
        for(String str:set){
            list1.add(str);
        }
        Collections.sort(list1);
        return list1;
    }

    private static String charArray2String(char[] chars){
        String str = "";
        for(char c:chars){
            str+=c;
        }
        return str;
    }

    public static void main(String[] args){
        for(String s:Permutation("abcdefg")){
            System.out.print(s+",");
        }
    }
}
