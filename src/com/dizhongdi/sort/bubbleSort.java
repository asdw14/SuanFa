package com.dizhongdi.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName:bubbleSort
 * Package:com.dizhongdi.sort
 * Description:
 *  冒泡排序
 * @Date: 2021/1/24 17:43
 * @Author:dizhongdi
 */
public class bubbleSort {
    public static void main(String[] args) {
        int a[] = {52,41,69,11,2,88,61,30};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a){
        for (int i = a.length; i>0; i--){
            for (int j = 0; j<i-1; j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
