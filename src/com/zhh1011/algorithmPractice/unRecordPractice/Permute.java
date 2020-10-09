package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permute {
    private HashMap<Integer,Boolean> map = new HashMap();
    private List<List<Integer>> list = new ArrayList();
    private int[] result;
    public List<List<Integer>> permute(int[] nums) {
        for(int i:nums){
            map.put(i,false);
        }
        result = new int[nums.length];
        dfs(0,nums);
        return list;
    }

    private void dfs(int i,int[] nums){
        if(i == result.length){
            List<Integer> re = new ArrayList<>();
            for(int num:result){
                re.add(num);
            }
            list.add(re);
            return;
        }
        for(int j=0;j < nums.length;j++){
            if(!map.get(nums[j])) {
                map.put(nums[j], true);
                result[i] = nums[j];
                dfs(++i,nums);
                i--;
                map.put(nums[j],false);
            }
        }
    }

    public static void main(String[] args){
        Permute p = new Permute();
        List<List<Integer>> list = p.permute(new int[]{1,2,3});
        for(List<Integer> l:list){
            System.out.println(l.toString());
        }
    }
}
