package com.dizhongdi.test;

/**
 * ClassName:TestFeibonacci
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/1/23 19:45
 * @Author:dizhongdi
 */
public class TestFeibonacci {
    public static void main(String[] args) {
        feibonacci(10);
    }
    public static int feibonacci(int i){
        if (i==1||i==2){
            return 1;
        }else {
            return feibonacci(i-1)+feibonacci(i-2);
        }
    }
}
