package com.dizhongdi.sort;

import java.util.Arrays;

/**
 * ClassName:SelectSort  选择排序
 * Package:com.dizhongdi.sort
 * Description: 循环一次，然后找到参加比较的这堆数据中最小的
 *  拿着这个最小的值和最前面的数据“交换位置”
 *  选择排序比冒泡排序好在每一次交换都是有意义的
 * @Date: 2021/1/24 20:15
 * @Author:dizhongdi
 */
public class SelectSort {
    public static void main(String[] args) {
        int a[] = {65,14,52,55,20,30,52,41};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectSort(int[] a){
        for (int i = 0; i < a.length -1; i++) {
            int min = i;
            for (int j = i; j < a.length ; j++){
                if (a[j]<a[min]){
                    min = j;
                }
            }
            if(i!=min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
