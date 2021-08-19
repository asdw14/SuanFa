package com.dizhongdi.sort;

import java.util.Arrays;

/**
 * ClassName:ShellSort
 * Package:com.dizhongdi.sort
 * Description:
 *  希尔排序
 * @Date: 2021/1/29 21:21
 * @Author:dizhongdi
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {10,20,41,2,0,1,6,5,7,9};
        Arrays.toString(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        //遍历所有步长
        for (int d = arr.length/2; d>0; d/=2){
            //遍历所有元素
            for (int i = d; i<arr.length; i++){
                //遍历本组中所有元素
                for (int j =i-d; j>=0; j-=d){
                    //如果当前元素大于加上步长后的那个元素
                    if (arr[j]>arr[j+d]){
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
            int k = 1;
            System.out.println("第"+k+++"次排序结果："+Arrays.toString(arr));
        }
    }
}
