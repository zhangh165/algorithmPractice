package com.zhh1011.algorithmPractice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(8);
        list1.add(4);
        list1.add(6);
        list1.add(9);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list1.retainAll(list2);
        System.out.println(list1);
    }
}
