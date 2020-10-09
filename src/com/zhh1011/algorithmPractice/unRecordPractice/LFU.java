package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFU {
    class Unit{
        int val;
        int fre;
        Unit(int val){
            this.val = val;
            fre = 0;
        }
        void add(){
            fre++;
        }
    }
    Map<Integer,Unit> map = new HashMap();
    Queue<Map.Entry<Integer,Unit>> queue = new PriorityQueue<>((x,y)->y.getValue().fre-x.getValue().fre);
    int size;
    public LFU(int capacity) {
        size = capacity;
        queue.addAll(map.entrySet());
    }

    public int get(int key) {
        Unit unit = map.get(key);
        unit.add();
        return unit.val;
    }

    public void put(int key, int value) {
        if(map.size() == size){
            int removeKey= queue.peek().getKey();
            map.remove(removeKey);
        }
        map.put(key,new Unit(value));
        queue.clear();
        queue.addAll(map.entrySet());
    }

    public static void main(String[] args){
        LFU cache = new LFU(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4

    }
}
