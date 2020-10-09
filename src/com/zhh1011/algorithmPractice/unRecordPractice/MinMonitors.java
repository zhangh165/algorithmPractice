package com.zhh1011.algorithmPractice.unRecordPractice;

public class MinMonitors {
    int[] nums;
    boolean[] flag;
    public int min_monitors (String inputs) {
        if (inputs == null || inputs.equals("")) {
            return 0;
        }
        char[] chars = inputs.toCharArray();
        nums = new int[chars.length];
        flag = new boolean[nums.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }
        int count = 0;
        int i = 0;
        count = dfs(0,count);
        return count;
    }
    int dfs(int i,int count){
        if(i >= nums.length-1 && nums[i]==1){
            return 0;
        }
            int left = i*2+1 < nums.length? i*2+1:nums.length-1;
            int right = i*2+2 < nums.length? i*2+2:nums.length-1;
            flag[i] = true;
            flag[left] = true;
            flag[right] = true;
            count = dfs(left,count);
            count = dfs(right,count);
        count++;
        return count;
    }

    public static void main(String[] args){
        MinMonitors m = new MinMonitors();
        System.out.println(m.min_monitors("11100111"));
    }
}
