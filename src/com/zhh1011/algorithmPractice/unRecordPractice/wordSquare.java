package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * ball
 * area
 * lead
 * lady
 *
 *
 *
 *
 * word Square
 */
public class wordSquare {
    public static boolean check(char[][] args){
        for(int i = 0; i < args[0].length;i++){
            for(int j = i+1; j < args.length;j++){
                if(args[i][j]!= args[j][i]){
                    return false;
                }else {
                    //do nothing
                }
            }
        }
        return true;
    }
    private static String[] result;
    private static int[] h;
    private static int count = 0;

    public static int countWordSquare(String[] args){
        result = new String[args[0].length()];
        h = new int[args[0].length()];
        helper(args,0);
        return count;
    }

    private static void helper(String[] args,int k){
        if(k == result.length){
            if(check(stringArray2chars(result))){count++;}
            return;
        }
        for(int i = 0;i < args.length;i++){
            if(h[i] == 1){
                continue;
            }
            result[k] = args[i];
            h[i] = 1;
            //check
            helper(args,k+1);
            h[i] = 0;
        }
    }

    private static char[][] stringArray2chars(String[] args){
        return null;
    }
}

class TreeNode0{
    public char val;
    public List<TreeNode0> list = new ArrayList<>();

    public TreeNode0(char val) {
        this.val = val;
    }

    public TreeNode0() {
    }

    public static TreeNode0 init(String args){
        if(null == args|| args.length() == 0){return new TreeNode0();}
        TreeNode0 root = new TreeNode0();
        TreeNode0 result = root;
        for(int i = 0; i < args.length();i++){
            TreeNode0 temp = new TreeNode0(args.charAt(i));
            //TODO： 查重
            root.list.add(temp);
            root = temp;
        }
        return result;
    }

    public static boolean search(String args){
        return false;
    }
}
