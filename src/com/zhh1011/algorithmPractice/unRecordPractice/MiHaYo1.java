package com.zhh1011.algorithmPractice.unRecordPractice;

/**
 * 双指针
 */
public class MiHaYo1 {
    int[] a;
    int rep;
    int delete;

    MiHaYo1(int n){
        a = new int[n];
    }

    void initArray(String str){

    }

    void delArray(){
        int head = 0,last= a.length -1;

        while (head<a.length-1 && last >=0){
            while ( head<a.length-1&& a[head] == head+1){
                head++;
            }
            if(a[head] != head+1) {
                int index = a[head];
                swap(index - 1, head);
                head++;
            }
            while (last >0&& a[last] == last+1 ) {
                last--;
            }
            if(a[last] != last+1) {
                int index = a[last];
                swap(index - 1, last);
                last--;
            }
        }

        getAnswer();
    }

    void delArray2(){
        int i = 0;
        int length = a.length;
        int index = 0;
        while (i < length){
            if(a[i] != (i+1)){
                index = a[i];
                if(a[index-1] == index){
                    i++;
                    continue;
                }
                swap(i,index-1);
            }else {
                i++;
            }
        }

        getAnswer();
    }

    void getAnswer(){
        for(int i = 0; i< a.length;i++){
            if(a[i] != i+1){
                delete = i+1;
                rep = a[i];
            }
        }
    }

    void swap(int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] =temp;
    }

    public static void main(String[] args){
        MiHaYo1 test = new MiHaYo1(6);
        test.a = new int[]{3,4,2,1,3,6,4};
        test.delArray2();

        System.out.println(test.rep+" "+test.delete);
    }
}
