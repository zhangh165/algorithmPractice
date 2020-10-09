package com.zhh1011.algorithmPractice.leetcode;

import com.zhh1011.algorithmPractice.Util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * author: dsa44
 * create time: 2020/9/26 9:43
 */
public class LT113_pathSum2 {
    static List<List<Integer>> ret = new LinkedList<List<Integer>>();
    static Deque<Integer> path = new LinkedList<Integer>();

    public static List<List<Integer>> getResult(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }

    public static void main(String[] args) {

    }
}