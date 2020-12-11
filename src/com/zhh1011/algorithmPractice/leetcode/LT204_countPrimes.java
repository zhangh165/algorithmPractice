package com.zhh1011.algorithmPractice.leetcode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @since JDK1.8
 * @author lenovo
 * @date 2020年12月3日 上午9:20:54
 */
public class LT204_countPrimes {
	public static boolean isPrime(long n) {

        if(n > 2 && (n & 1) == 0)
           return false;
        /* 运用试除法:
         * 1.只有奇数需要被测试
         * 2.测试范围从2与根号{n},反之亦然 */
        for(int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        int which=0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.txt")));
        for(int i=2;i<=2;i++){
            if(isPrime(i)){
                which++;
                if(which % 10 == 0 ){System.out.println();}
                System.out.print(i+", ");
                bw.write(i+", ");
            }
        }
        bw.close();
        System.out.println();
        System.out.print("共有"+which+"个质数.");
    }
}
