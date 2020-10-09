package com.zhh1011.algorithmPractice.unRecordPractice;

import com.zhh1011.algorithmPractice.dataStructure.MyQueue;

/**
 * 题目描述
 * 输入10个整数，将其中最小的数与第一个数对换，把最大的数与最后一个数对换。写三个函数； ①输入10个数；②进行处理；③输出10个数。
 *
 * 输入
 * 10个整数
 *
 * 输出
 * 整理后的十个数，每个数后跟一个空格（注意最后一个数后也有空格）
 *
 * 样例输入
 * 2 1 3 4 5 6 7 8 10 9
 * 样例输出
 * 1 2 3 4 5 6 7 8 9 10
 */
public class NumberSwap {
    private MyQueue<Integer> queue = new MyQueue();

    public NumberSwap(){

    }

    public NumberSwap(String str){
        readAndSwap(str);
    }

    private void readAndSwap(String str){
        String[] nums = str.split(" ");
        int max = Integer.parseInt(nums[1]),min = max,maxIndex = 0,minIndex = 0;
        int temp;
        int index = 0;
        for(String num:nums){
            if(num == null || !num.equals("")) {
                temp = Integer.parseInt(num);
            }else {
                continue;
            }
            if(temp > max){
                max = temp;
                maxIndex = index;
            }
            if(temp < min){
                min  = temp;
                minIndex = index;
            }
            queue.push(temp);
            index++;
        }
        index = 0;
        int head = queue.getFront();
        int last = queue.getRear();
        while (!queue.isEmpty()){
            index++;
            if(index-1 == 0){
                System.out.print(" "+min);
            }else if(queue.size() == 1){
                System.out.print(" "+max);
            }else if(index-1 == minIndex){
                System.out.print(" "+head);
            }else if(index-1 == maxIndex){
                System.out.print(" "+last);
            }else {
                System.out.print(" " + queue.getFront());
            }
            queue.pop();
        }
        System.out.println();
    }
}
