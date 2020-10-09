package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhangh165
 */
public class GDFS {
    class Node{
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private ArrayList<Node>[] vector;
    private boolean[] isView;

    public GDFS(int[][] map){
        vector = new ArrayList[map.length];
        isView = new boolean[map.length];
        Arrays.fill(isView,false);
        init(map);
    }

    private void init(int[][] map){
        for(int i = 0;i < map.length;i++){
            ArrayList<Node> list = new ArrayList<Node>();
            for(int j = 0;j < map[i].length;j++){
                if(map[i][j] != 0){
                    list.add(new Node(j,map[i][j]));
                }
            }
            vector[i] = list;
        }
    }

    private void dfs(int u){
        if(isView[u]){
            return;
        }
        isView[u] = true;
        System.out.println("-->"+u);
        for(Node node:vector[u]){
                dfs(node.v);
        }
    }

    public void dfsTrave(){
        for(int i=0;i< vector.length;i++){
            dfs(i);
        }
        System.out.println("end");
    }

    public void bfsTrave(){
        for(int i=0;i< vector.length;i++){
            bfs(i);
        }
        System.out.println("end");
    }

    private void bfs(int u){
        if(isView[u]){
            return;
        }
        Queue<ArrayList<Node>> queue = new LinkedBlockingQueue<ArrayList<Node>>();
        System.out.println("-->"+u);
        isView[u] = true;
        queue.add(vector[u]);
        while(!queue.isEmpty()){
            for(Node node:queue.poll()){
                if(isView[node.v]) {
                    continue;
                }
                System.out.println("-->"+node.v);
                isView[node.v] = true;
                queue.add(vector[node.v]);
            }
        }
    }
    public String dijkstra(int end){
        int[] minValue = new int[isView.length],
                path = new int[isView.length];
        Arrays.fill(minValue,Integer.MAX_VALUE);
        minValue[0] = 0;
        for(int i =0;i< path.length;i++){
            path[i] = i;
        }
        int index = findLowestCostNode(minValue);
        while (index!= end){
            ArrayList<Node> list = vector[index];
            isView[index] = true;
            for(Node node:list){
                int value = minValue[index] + node.w;
                boolean flag = !isView[node.v]&&minValue[node.v] >value;
                if(flag){
                    minValue[node.v] = value;
                    path[node.v] = index;
                }
            }
            System.out.println("-->"+index);
            index = findLowestCostNode(minValue);
        }
        StringBuffer sb = new StringBuffer();
        index = end;
        while(path[index] != index){
            sb.append(index+"<--");
            index = path[index];
        }
        System.out.println(Arrays.toString(minValue));
        System.out.println(Arrays.toString(path));
        return sb.toString();
    }

    public int findLowestCostNode(int[] minValues){
        int minIndex = 0,min = Integer.MAX_VALUE;
        for(int i=0;i< minValues.length;i++){
            if(min > minValues[i] &&!isView[i]){
                min = minValues[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args){
        int[][] map = new int[][]{
                {0,1,0,4,4,0},
                {0,0,0,2,0,0},
                {0,0,0,0,0,1},
                {0,0,2,0,3,0},
                {0,0,0,0,0,3},
                {0,0,0,0,0,0}
        };

        GDFS gdfs = new GDFS(map);
        System.out.println(gdfs.dijkstra(5));
    }
}
