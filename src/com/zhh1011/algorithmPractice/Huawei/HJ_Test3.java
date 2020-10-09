package com.zhh1011.algorithmPractice.Huawei;

import java.util.Arrays;

public class HJ_Test3 {
    public static String getResult(String str){
        String[] arrays = str.split(",");
        for(int i = 0;i < arrays.length;i++){
            String s = arrays[i];
            int temp = checkElemnet(s);
            switch (temp){
                case -2:
                    continue;
                case -1:
                    return "-1";
                default:
                    if(!dealData(arrays,i,temp)){
                        return "-1";
                    }
            }
        }
        return output(arrays);
    }

    public static boolean dealData(String[] array,int i,int j){
        int temp = checkElemnet(array[j]);
        if(temp==-1){
            return false;
        }else if(temp>=0){
            if(!dealData(array,j,temp)){
                return false;
            }
        }
        array[i] = "+"+array[i]+"+";
        char charTemp = (char) (j+'A');
        String temp1 = "<"+charTemp+">";
        String[] twoStr = array[i].split(temp1);
        array[i] = twoStr[0]+array[j]+twoStr[1];
        array[i] = array[i].replaceAll("\\+","");
        return true;
    }

    public static int checkElemnet(String str){
        if(!(str.contains("<")&&str.contains("<"))){
            return -2;
        }else if(str.indexOf("<") - str.indexOf(">")==-2&&(str.charAt(str.indexOf("<")+1) >='A'&&str.charAt(str.indexOf("<")+1)<='Z')){
            return str.charAt(str.indexOf("<")+1)-'A';
        }else {
            return -1;
        }
    }

    public static String output(String[] strs){
        String result = Arrays.toString(strs);
        result = result.replaceAll("\\[","");
        result = result.replaceFirst("]","");
        return result;
    }

    public static void main(String[] args){
        //System.out.println(("<B>12".charAt("<B>12".indexOf("<")+1)-'A'));
        System.out.println(getResult("A<C>1A,A2<A>A,A3A"));
    }
}
