package com.zhh1011.algorithmPractice.unRecordPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 并查集
 */
public class MiHaYo2 {
    private int[] father;

    public MiHaYo2(){
        father = new int[100];
        initFatherArray();
    }

    private void initFatherArray(){
        for(int i=0;i< father.length;i++){
            father[i] = i;
        }
    }

    private int findFather(int x){
        int a =x;
        while (x != father[x]){
            x = father[x];
        }

        while (a != father[a]){
            int z = a;
            a = father[a];
            father[z] = x;
        }

        return x;
    }

    private void union2Set(int a,int b){
        int faA = findFather(a);
        int faB = findFather(b);

        if(faA != faB){
            father[faA] = faB;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        String[] numStrArray = str.split(",");
        int[] numArray =new int[numStrArray.length];
        MiHaYo2 uss = new MiHaYo2();
        for(int i=0;i<numStrArray.length;i++){
            numArray[i] = Integer.valueOf(numStrArray[i]);
        }

        for(int i = 0; i < numArray.length ;i+=2){
            uss.union2Set(numArray[i],numArray[i+1]);
        }

        while (null != (str = bf.readLine())){
            numStrArray = str.split(",");
            if(uss.findFather(Integer.valueOf(numStrArray[0])) != uss.findFather(Integer.valueOf(numStrArray[1]))){
                System.out.println("不是队友");
            }else {
                System.out.println("是队友");
            }
        }
        bf.close();
    }

}
