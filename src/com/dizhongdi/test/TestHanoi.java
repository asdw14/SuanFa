package com.dizhongdi.test;

import java.util.NoSuchElementException;

/**
 * ClassName:TestHanoi
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/1/24 17:02
 * @Author:dizhongdi
 */
public class TestHanoi {
    public static void main(String[] args) {
        hanoi(10,'A','B','C');
    }

    /**
     *
     * @param n  共有n个盘子
     * @param from  开始的柱子
     * @param in    中间的柱子
     * @param to    目标柱子
     */
    public static void hanoi(int n,char from, char in, char to){
        if(n==1){
            System.out.println("将第1个盘子从"+from+"移到"+to);
        }else {
            //移动上面所有盘子到中间位置
            hanoi(n-1,from,to,in);
            //移动下面的盘子
            System.out.println("第"+n+"个盘子从"+from+"移到"+to);
            //把上面所有的盘子从中间位置移到目标位置
            hanoi(n-1,in,from,to);
        }
    }
}
