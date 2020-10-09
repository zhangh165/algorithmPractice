package com.zhh1011.algorithmPractice.unRecordPractice.Huawei;

/**
 * 题目标题：
 *
 * 计算两个字符串的最大公共字串的长度，字符不区分大小写
 *
 * 详细描述：
 *
 * 接口说明
 *
 * 原型：
 *
 * int getCommonStrLength(char * pFirstStr, char * pSecondStr);
 *
 * 输入参数：
 *
 *      char * pFirstStr //第一个字符串
 *
 *      char * pSecondStr//第二个字符串
 */
public class HJ75 {
    public static int getResult(String firstStr,String secondStr){
        char[] firstChars = new char[firstStr.length()+1];
        char[] secondChars = new char[secondStr.length()+1];
        System.arraycopy(firstStr.toCharArray(),0,firstChars,1,firstStr.length());
        System.arraycopy(secondStr.toCharArray(),0,secondChars,1,secondStr.length());
        int length = firstChars.length > secondChars.length?firstChars.length:secondChars.length;
        int[][] dp = new int[length+1][length+1];
        int result = 0;
        for(int i = 1; i < firstChars.length;i++){
            for(int j = 1; j < secondChars.length;j++){
                if(firstChars[i] == secondChars[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    result = Math.max(result,dp[i][j]);
                }else {
                    //dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //return dp[firstChars.length-1][secondChars.length-1];
        return result;
    }

    public static void main(String[] args){
        System.out.println(getResult(
                "bacefaebcdfabfaadebdaacabbdabcfffbdcebaabecefddfaceeebaeabebbad",
                "dedcecfbbbecaffedcedbadadbbfaafcafdd"));
    }
}
