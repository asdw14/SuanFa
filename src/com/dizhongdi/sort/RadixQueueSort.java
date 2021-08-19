package com.dizhongdi.sort;

import java.util.Arrays;

/**
 * ClassName:RadixQueueSort
 * Package:com.dizhongdi.sort
 * Description:
 *      基数排序的队列实现
 * @Date: 2021/2/1 17:16
 * @Author:dizhongdi
 */

class Queue {
    int elements[];
    public Queue() {
        elements = new int[0];
    }

    //入队
    public void add(int element){
        //创建新数组
        int newarr[] = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newarr[i] = elements[i];
        }
        newarr[newarr.length - 1] = element;
        elements = newarr;
    }

    //出队
    public int poll(){
        //如果队列没有元素抛异常
        if (elements.length<=0){
            throw new RuntimeException("队列已空");
        }
        //取出队列最前面的元素
        int element = elements[0];
        int newarr[] = new int[elements.length - 1];
        //复制原数组中的元素
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = elements[i+1];
        }
        elements=newarr;
        //返回队列最前面的元素
        return element;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}

public class RadixQueueSort {
    public static void main(String[] args) {
        int[] arr = {100,5,6,52,789,985,20,962,455};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


//    基数排序
    public static void radixSort(int[] arr){
        //找出数组中最大的数，就可以知道要比几次
        int max = Integer.MIN_VALUE;
        for (int i =0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        //最大数的位数
        int maxLength = (max + "").length();
        //用于临时储存数据的队列
        Queue[] temp = new Queue[10];
        for (int i = 0;i<temp.length; i++){
            temp[i] = new Queue();
        }
        //根据最大长度的数决定比较的次数
        for (int i=0,n=1 ;i<maxLength;i++,n*=10){
            //把每一个数字分别计算余数
            for (int j = 0; j<arr.length; j++){
                //计算余数
                int ys = arr[j]/n%10;
                //把当前遍历的数据放入指定的队列中
                temp[ys].add(arr[j]);
            }
            //记录取的元素需要放的位置
            int index = 0;
            //把数字取出来
            for (int k = 0; k<temp.length;k++){
                while (!temp[k].isEmpty()){
                        //取出元素
                        arr[index] = temp[k].poll();
                        //记录下一个位置
                        index++;
                    }
            }
        }
    }

//    private static void radixSort(int[] arr) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i<arr.length; i++){
//            if (arr[i]>max){
//                max=arr[i];
//            }
//        }
//        int maxLenght = (max+"").length();
//        Queue[] temp = new Queue[10];
//        for (int i = 0; i< temp.length; i++){
//            temp[i] = new Queue();
//        }
//        for (int i = 0,n = 1; i<maxLenght;i++,n*=10){
//            for (int j = 0; j< arr.length; j++){
//                int ys = arr[j]/n%10;
//                temp[ys].add(arr[j]);
//            }
//            int index = 0;
//            for (int k = 0; k<temp.length; k++){
//                while (!temp[k].isEmpty()){
//                    arr[index] = temp[k].poll();
//                    index++;
//                }
//            }
//        }
//    }

}
