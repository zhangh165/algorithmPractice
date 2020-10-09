package com.zhh1011.algorithmPractice.unRecordPractice;

/**
 * lc 3 无重复最长字符串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.equals("")){
            return 0;
        }
        int index = 0;//子串头字符下标
        int re = 0,length = 0;//re为最大子串长度，length为当前子串长度
        char[] chars = s.toCharArray();
        for(int i=0;i < s.length();i++){//第一层扫描整个字符串
            for(int j = index ;j<i;j++){//当i+1时，对子串进行非重验证
                if(chars[j]==chars[i]){//如果重复
                    re = Math.max(re,length);//比较当前子串长度与最大长度
                    index = j+1;//子串头下标重置，dvdf中在v处第一次重置下标
                }
            }
            length= i-index+1;//更新当前子串长度
        }
        return Math.max(re,length);//防止未遇到重复不更新最大长度，用例"au"
    }

    public static void main(String[] args){
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("au"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }
}
