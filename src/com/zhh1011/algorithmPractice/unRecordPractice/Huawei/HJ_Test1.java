package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

public class HJ_Test1 {
    private static int wordCount = 0;
    private static int getWord =  0;
    private static int cutBorad = 0;
    public static int getResult(){
        return wordCount;
    }

    public static void keyA(){
        if(getWord != 0){
            wordCount = 0;
            getWord = 0;
        }
        wordCount++;
    }

    private static void keyCA(){
        getWord = wordCount;
    }

    private static void keyCC(){
        if (getWord == 0){
            return;
        }
        cutBorad = getWord;
    }

    private static void keyCX(){
        if (getWord == 0){
            return;
        }
        cutBorad = getWord;
        wordCount -= getWord;
    }

    private static void keyCV(){
        if(getWord != 0){
            wordCount = 0;
            getWord = 0;
        }
        wordCount+=cutBorad;
    }

    public static void dealInput(String str){
        String[] args = str.split(" ");
        for(String s:args){
            switch (s){
                case "1":
                    keyA();
                    break;
                case "2":
                    keyCC();
                    break;
                case "3":
                    keyCX();
                    break;
                case "4":
                    keyCV();
                    break;
                case "5":
                    keyCA();
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args){
        dealInput("1 1 5 1 5 2 4 4");
        System.out.println(getResult());
    }
}
