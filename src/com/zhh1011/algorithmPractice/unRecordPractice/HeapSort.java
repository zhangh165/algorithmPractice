package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.Arrays;

public class HeapSort {
    final int maxn = 100;
    private int n;
    private int[] heap = new int[maxn];

    public HeapSort(int[] heap) {
        this.n = heap.length;
        //createHeap(heap);
        createSmallHeap(heap);
    }

    public void insert(int x){
        heap[++n] = x;
        upAdjust(1,n);
    }

    public void dowmAdjust(int low,int high){
        int i = low,j = 2*i;

        while (j <= high){
            if(j+i <= high && heap[j+1] > heap[j]){
                j=j+1;
            }

            if(heap[j] > heap[i]){
                swap(i,j);
                //进入子树
                i = j;
                j = i * 2;
            }else {
                break;
            }
        }
    }

    public void downAdjust(int low,int high){
        int i = low,j = i*2;

        while(j <= high){
            if(j+i <= high && heap[j+1] < heap[j ]){
                j = j + 1;
            }

            if(heap[j] < heap[i]){
                swap(i,j);
                i= j;
                j = 2 * i;
            }else {
                break;
            }
        }

    }

    public void createHeap(int[] arr){
        for(int i = 1;i <= n;i++){
            heap[i] = arr[i-1];
        }
        System.out.println(toString());
        for(int i = n/2;i>=1;i--){
            dowmAdjust(i,n);
        }
    }

    public void createSmallHeap(int[] arr){
        for(int i = 1;i <= n;i++){
            heap[i] = arr[i-1];
        }
        System.out.println(toString());
        for(int i = n/2;i>=1;i--){
            downAdjust(i,n);
        }
    }

    public void upAdjust(int low,int high){
        int i = high,j = i/2;
        while (j >= low){
            if(heap[i] > heap[j]){
                swap(i,j);
                i = j;
                j = i/2;
            }else {
                break;
            }
        }
    }

    public void upAdjust1(int low,int high){
        int i = high,j = i/2;
        while (j >= low){
            if(heap[i] < heap[j]){
                swap(i,j);
                i = j;
                j = i/2;
            }else {
                break;
            }
        }
    }

    public void heapSort(){
        for (int i = n; i>=1;i--){
            System.out.println("Heap Sort -->"+i);
            swap(i,1);
            dowmAdjust(1,i-1);
        }
    }

    public void heapSort1(){
        for (int i = n; i>=1;i--){
            System.out.println("Heap Sort -->"+i);
            swap(i,1);
            downAdjust(1,i-1);
        }
    }

    public void deleteTop(){
        heap[1] = heap[n--];
        dowmAdjust(1,n);
    }
    private void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public String toString(){
        return Arrays.toString(heap).replaceAll("0,","");
    }

    public static void main(String[] args){
        HeapSort test = new HeapSort(new int[]{85,55,82,57,68,92,99,98,66,56});
        System.out.println(test.n);
        System.out.println(test.toString());
        test.heapSort1();
        System.out.println(test.toString());
    }
}
