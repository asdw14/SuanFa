package com.dizhongdi.sort;

import java.util.Arrays;

/**
 * ClassName:InsertSort
 * Package:com.dizhongdi.sort
 * Description:
 *      插入排序
 * @Date: 2021/1/29 20:17
 * @Author:dizhongdi
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5,3,2,8,5,9,1,0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr)  {
        //遍历所有数字
        for (int i = 1; i< arr.length; i++){
            //如果当前数字比前一个数字小
            if (arr[i]<arr[i-1]){
                int temp = arr[i];
                int j;
                //遍历当前数字前面所有的数字
                for (j=i-1;j>=0 && temp < arr[j]; j--){
                    //把前一个数字赋给后一个数字
                    arr[j+1] = arr[j];
                }
                //把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
                arr[j+1] = temp;
            }
        }
    }


//    public static void insertSort(int[] arr)  {
//        for (int i = 1; i< arr.length; i++){
//            if (arr[i] < arr[i-1]){
//                int temp = arr[i];
//                int j;
//                for (j = i-1; j>=0&&temp<arr[j];j--){
//                    arr[j+1] = arr[j];
//                }
//                arr[j+1] = temp;
//            }
//        }
//    }

}
