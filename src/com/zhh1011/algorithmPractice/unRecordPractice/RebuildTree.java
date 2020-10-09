package com.zhh1011.algorithmPractice.unRecordPractice;

import com.zhh1011.algorithmPractice.dataStructure.Node;
import com.zhh1011.algorithmPractice.dataStructure.Tree;

import java.util.HashMap;
import java.util.Map;

public class RebuildTree {
    private static int[] per,in;
    private static Map<Integer,Integer> indexMap = new HashMap<Integer, Integer>();

    public static Node<Integer> rebuildTreeBy2String(int[] per, int[] in){
        for(int i = 0; i < in.length;i++){
            indexMap.put(in[i],i);
        }
        for (Map.Entry<Integer,Integer> e:
             indexMap.entrySet()) {
            System.out.println(e.getKey()+" -->"+e.getValue());
        }
        RebuildTree.per = per;
        RebuildTree.in = in;
        return rebuildTreeBy2String(0,per.length,0,in.length);
    }

    private static Node<Integer> rebuildTreeBy2String(int perHead,int perLast,int inHead,int inLast){
        if(perHead >perLast || perHead >= per.length){
            return null;
        }

        Node<Integer> root = new Node<Integer>(per[perHead]);
        int index = 0;
        try {
            index = indexMap.get(per[perHead]);
        }catch (Exception e){
            System.out.println("-->"+per[perHead]);
            throw new RuntimeException(e);
        }
        int leftLength = index - inHead;

        root.setLeftNode(rebuildTreeBy2String(perHead+1,perHead+leftLength,inHead,index-1));
        root.setRightNode(rebuildTreeBy2String(perHead+leftLength+1,perLast,index+1,inLast));

        return root;
    }

    public static void main(String[] args){
        Node<Integer> root = rebuildTreeBy2String(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        Tree<Integer> tree = new Tree<Integer>(root);

        System.out.println(tree.perOrder());
    }
}
