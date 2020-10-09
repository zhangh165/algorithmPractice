package com.zhh1011.algorithmPractice.unRecordPractice;

public class MyAtoi {
    char[] nums = new char[]{' ','-','+','0','1','2','3','4','5','6','7','8','9'};

    int[] num = new int[100];
    int start = 0;
    int size = 0;

    boolean isNagetive = false;

    private void push(int i){
        if(start != num.length){
            num[start] = i;
            start++;
            size++;
        }else {
            throw new IndexOutOfBoundsException("bigger than 2^32 or less than -2^32+1");
        }
    }

    private int pop(){
        if(start != 0){
            size--;
            return num[--start];
        }else{
            throw new RuntimeException("no number in stack");
        }
    }

    public int myAtoi(String str) {
        if(str == null || str.equals("")){
            return  0;
        }
        char[] chars = str.toCharArray();
        if(!inNums(chars[0])){
            return 0;
        }else{
            try {
                isNum(chars,0);
            }catch (IndexOutOfBoundsException e){
                if(isNagetive){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }

            int re = 0;
            for(int j = 1; size!=0;j*=10){
                re+=pop()*j;
            }
            return  isNagetive?-re:re;
        }
    }

    public static void main(String[] args){
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("  0000000000012345678"));
    }

    public void isNum(char[] chars,int i){
        if(i< chars.length && inNums(chars[i])){
            switch (chars[i]){
                case ' ':
                case '+':
                    isNum(chars,++i);
                    break;
                case '-':
                    isNagetive = true;
                    isNum(chars,++i);
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    push(chars[i]-'0');
                    isNum(chars,++i);
                    break;
                default:
                    break;
            }
        }

    }

    private boolean inNums(char c){
        for(char c0:nums){
            if(c-c0 == 0){
                return true;
            }
        }
        return false;
    }
}
