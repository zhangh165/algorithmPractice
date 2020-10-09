package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ5 {
    public static int getResult(String str){
        char[] chars = new char[str.length()-2];
        System.arraycopy(str.toCharArray(),2,chars,0,str.length()-2);
        int result = 0;
        for(int i = 0,j = chars.length-1;j >= 0;i++,j--){
            int temp = 0;
            if(chars[j] >= '0' && chars[j] <= '9'){
                temp= chars[j]-'0';
            }else {
                temp = chars[j]-'A'+1+9;
            }
            result+=((temp)*((int)Math.pow(16,i)));
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(getResult("0x76E"));
    }
}
