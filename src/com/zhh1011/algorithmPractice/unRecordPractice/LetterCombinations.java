package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private List<String> list = new ArrayList<>();
    private char[][] catchs = new char[][]{
        {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
        {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };
    private char[] oneAns;
    public List<String> letterCombinations(String digits) {
        oneAns = new char[digits.length()];
        generateString(digits,0);
        return list;
    }
    private void generateString(String s,int i){
        if(i == s.length()){
            String ans = "";
            for(char c:oneAns)
            {
                ans+=c;
            }
            list.add(ans);
            return;
        }
        int num = s.charAt(i)-'0';
        char[] cur3Words = getWord(num);
        for(int j = 0;j< cur3Words.length;j++){
            oneAns[i] = cur3Words[j];
            generateString(s,i+1);
        }
    }
    private char[] getWord(int num){
        return catchs[num-2];
    }
    public static void main(String[] args){
        LetterCombinations test = new LetterCombinations();
//        System.out.println(Arrays.toString(test.getWord(3)));
        System.out.println(test.letterCombinations("345"));
    }

}
