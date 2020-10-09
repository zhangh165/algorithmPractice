package com.zhh1011.algorithmPractice.unRecordPractice;

/**
 * author: dsa44
 * create time: 2020/9/29 19:23
 */
public class XY_T1 {
    public static String getResult(String number) {
        int num = -1;
        try {
            num = Integer.parseInt(number);
        }catch (Exception e){
            return "INPUTERROR";
        }
        if(num > 0x7FFF || num < 0xFFFF0001){
            return  "NODATA";
        }
        String bin = getBinaryNum(num);
        return bin+","+getSixteenNum(bin);
    }

    private static String getBinaryNum(int num){
        String str = num > 0 ?Integer.toBinaryString(num):Integer.toBinaryString(num).substring(17,32);
        StringBuilder sb = new StringBuilder();
        sb.append(num > 0? 0:1);
        while(sb.length()+str.length() < 16){
            sb.append(0);
        }
        sb.append(str);
        return sb.toString();
    }

    private static String getSixteenNum(String binNum){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < binNum.length();i+=4){
            String str = binNum.substring(i,i+4);
            char[] chars = str.toCharArray();
            int temp = 0;
            for(int x = 0,j=3;x < 4;x++,j--){
                if(chars[x] == '1'){
                    temp+=Math.pow(2,j);
                }
            }
            if(temp < 9){
                sb.append(temp);
            }else {
                char c = (char) ('A'+(temp-10));
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = getResult("15");
        System.out.println(str+" "+str.length());
        System.out.println(0xFFFF0001+" "+Integer.MIN_VALUE);
    }
}