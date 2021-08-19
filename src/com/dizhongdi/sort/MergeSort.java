package com.dizhongdi.sort;

import java.util.Arrays;

/**
 * ClassName:MergeSort
 * Package:com.dizhongdi.sort
 * Description:
 *  归并排序
 * @Date: 2021/1/31 14:34
 * @Author:dizhongdi
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,5,1,4,6,2,5,9,7,4,5};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //归并排序
    public static void mergeSort(int[] arr,int low, int high){
        int middle = (low+high)/2;
        if (middle!=low) {
            //处理左边的
            mergeSort(arr, low, middle);
            //处理右边的
            mergeSort(arr, middle + 1, high);
            //归并
            merge(arr,low,middle,high);
        }
    }

    /**
     *
     * @param arr 要排序的数组
     * @param low 起始
     * @param middle 中间
     * @param high 结束
     */
    public static void merge(int[] arr, int low, int middle, int high){
        //用于存储归并后的临时数组
        int[] temp = new int[high-low+1];
        //记录第一个数组中需要遍历的下标
        int i = low;
        //记录第二个数组中需要遍历的下标
        int j = middle+1;
        //用于记录在临时数组中存放的下标
        int index = 0;
        //遍历两个数组取出小的数字，放入临时数组中
        while (i<=middle&&j<=high){
            //第一个数组的数据更小
            if (arr[i]<arr[j]){
                temp[index] = arr[i];
                index++;
                i++;
            }else {
                temp[index] = arr[j];
                index++;
                j++;
            }
        }
        //处理多余的数据
        while (i<=middle){
            temp[index] = arr[i];
            index++;
            i++;
        }
        while (j<=high){
            temp[index] = arr[j];
            index++;
            j++;
        }
        for (int k = 0 ; k < temp.length; k++ ){
            arr[low+k] = temp[k];
        }

    }
}
