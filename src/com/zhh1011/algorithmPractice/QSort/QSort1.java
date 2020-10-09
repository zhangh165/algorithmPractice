package com.zhh1011.algorithmPractice.QSort;

import java.util.Arrays;

public class QSort1 {
    public int[] a;

    public QSort1(int[] a) {
        this.a = a;
    }

    public void qSort(){
        qSort(0,a.length-1);
    }
    private void qSort(int low, int high){
        if(low > high){
            return;
        }
        int i = low,j = high;
        int head = a[low];

        while(i < j){
            while (a[j] > head && i < j)
                j--;
            a[i] = a[j];
            while (a[i] < head && i< j)
                i++;
            a[j] = a[i];
        }

        a[j] = head;
        qSort(j+1,high);
        qSort(low,j-1);
    }

    public static void main(String[] args){
        QSort1 qSort1 = new QSort1(new int[]{35,18,16,72,24,65,12,88,46,28,55});
        qSort1.qSort();
        System.out.println(Arrays.toString(qSort1.a));
    }

}
