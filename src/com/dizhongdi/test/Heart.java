package com.dizhongdi.test;

/**
 * ClassName:Heart
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/2/14 12:23
 * @Author:dizhongdi
 */
public class Heart {
    public static void main(String[] args) {
        heart();
    }
    public static void heart() {
        for (double y = 1.5; y>-1.5; y-=0.1){
            for (double x = -1.5; x < 1.5; x+=0.05){
                double a = x*x+ y*y -1;
                if ((a*a*a - x*x*y*y*y)<=0){
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Yjm");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
