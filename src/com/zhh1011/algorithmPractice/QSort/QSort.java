package com.zhh1011.algorithmPractice.QSort;


public class QSort{
    private int[] a;

    public QSort(){

    }

    public QSort(int[] a){
        this.a = a;
    }

    public void sort(){
        sort(0,a.length -1);
    }

    public void sort(int left,int right){
        if(left > right || right < left || left==right){
            return;
        }
        if(left+1 == right){
            if(a[left] > a[right]){
                wrap(left,right);
            }
            return;
        }
        System.out.println("-->"+left);
        System.out.println("-->"+right);
        printArray();
        int left0 = left;
        int right0 = right;
        int head = a[right];
        System.out.println("--> head: "+head);
        boolean flag = false;

        while(left < right){
            while (a[left] <= head && left < right)
                left++;
            a[right] = a[left];
            while (a[right] > head && left < right)
                right--;
            a[left] = a[right];
            printArray();
        }

        System.out.println("--> mid: "+right);
        printArray();
        a[right] = head;
        printArray();

        sort(left+1, right0);
        sort(left0, left-1);
    }

    private void wrap(int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void printArray() {
        for (int i : a) {
            System.out.print(i+"\t");
        }
        System.out.println();
        int x = 0;
        for (int i : a) {
            System.out.print(x+++"\t");
        }
        System.out.println();
    }

    public static void main(String[] args){
        QSort ms = new QSort(new int[]{35,18,16,72,24,65,12,88,46,28,55});
        ms.sort();
        ms.printArray();
    }

}