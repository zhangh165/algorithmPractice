package com.zhh1011.algorithmPractice.unRecordPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Match {
    class pRoll{
        int falg = -1;
        String target;
        pRoll(int falg,String p){
            this.falg = falg;
            target = p;
        }
    }
    List<pRoll> pRolls = new ArrayList<>();
    public boolean Match (String s, String p) {
        if(s == null || s.equals("") || p ==null|| p.equals("")){
            return false;
        }
        transP(p);
        return isMatch(s);
    }

    public void transP(String p){
        char[] chars = p.toCharArray();
        for(int i=0;i < chars.length;i++) {
            char c = chars[i];
            if(c >= 'a'&& c <= 'z'){
                pRolls.add(new pRoll(1,c+""));
            }else if(c == '.'){
                pRolls.add(new pRoll(2,"."));
            }else if(c == '('){
                String str = "";
                i++;
                int j = i;
                for(; j< chars.length;j++){
                    if(chars[j]==')'){
                        break;
                    }
                    str= str+chars[j];
                }
                i=i+j-1;
                pRolls.add(new pRoll(3,str));
            }else if(c == '*'){
                pRoll pRol = pRolls.get(pRolls.size()-1);
                if(pRol.falg==2){
                    for(int j=i;j<chars.length;j++){
                        pRolls.add(new pRoll(2,"."));
                    }
                    break;
                }
                pRol.falg = 3;
            }
        }
        System.out.println("trans over");
    }
    public boolean isMatch(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        Iterator it =  pRolls.iterator();
        while (it.hasNext()){
            pRoll pRol = (pRoll) it.next();
            if(!(i < chars.length)){
                return false;
            }
            char c = chars[i];
            switch (pRol.falg){
                case 1:
                    if(!(c+"").equals(pRol.target)){
                        return  false;
                    }
                    i++;
                    it.remove();
                    break;
                case 2:
                    if(i == chars.length){
                        return false;
                    }
                    i++;
                    it.remove();
                    break;
                case 3:
                    boolean f = true;
                    while (f){
                        int length = pRol.target.length();
                        String str = "";
                        int j = 0;
                        for(;j < length&&(i+j)<chars.length;j++){
                            str=str+ chars[i+j];
                        }
                        f = str.equals(pRol.target);
                        i = f?i+j:i;
                    }
                    it.remove();
                    break;
                default:
                    break;
            }
        }
        System.out.println(i);
        return i == chars.length&&pRolls.isEmpty();
    }

    public static void main(String[] args){
        Match m = new Match();
        System.out.print(m.Match("bcccccbaccccacaa",".*bb*c*a*b*.*b*b*c*"));
    }
}
