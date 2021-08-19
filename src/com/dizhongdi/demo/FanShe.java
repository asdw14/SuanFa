package com.dizhongdi.demo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FanShe {
    public static void main(String[] args) {
    /*    Class c = Test01.class;
        try {
            Test01 t1 = (Test01) c.newInstance();
            System.out.println(t1.hashCode());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

   */
        int a[] = {90, 85, 99, 41, 65, 25, 46, 56, 77, 54, 20, 10};
        sort(a);
        System.out.println(a.length);
        int target = 99;
        int index = binarySearch(a,target);
        System.out.println(target+"的下标是"+index);
    }

    //封装冒泡排序方法sort
    public static void sort(int a[]){
        int temp, des = -1;
        for (int i = a.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //二分查找
    public static int binarySearch(int a[],int target){    //target：目标元素,返回目标元素的下标，-1表示不存在
        int begin = 0;  //开始元素
        int end = a.length-1;   //结束元素
        int mid = (end - begin)/2;                //中间的
        while (true){
//            if (begin==mid||end==mid){
//                return -1;
//            }
            if (a[mid]==target){
                return mid;
            }else {
                if (a[mid]>target){
                    end = mid-1;
                    mid = (end - begin)/2;
                }else {
                    begin = mid+1;
                    mid = (end - begin)/2;
                }
            }
        }

    }



    public static int[] delArray(int a[],int des){
        if (des>=a.length||des<0){
            throw new RuntimeException("要删除的元素超过了数组下标！！！");
        }
        int b[] = new int[a.length - 1];
        for (int i = 0; i < a.length; i++) {
            if (i == des) {
                continue;
            }else if (i < des) {
                b[i] = a[i];
            } else if (i > des) {
                b[i - 1] = a[i];
            }
        }
        return b;
    }
    public static void printIntArray(int a[]){
        if (a==null){
            System.out.println("null");
        }else {
            System.out.print("[");
            for (int i = 0; i < a.length; i++) {
                if (i < a.length - 1) {
                    System.out.print(a[i] + ", ");
                } else {
                    System.out.print(a[i]);
                }
            }
            System.out.println("]");
        }
    }
}