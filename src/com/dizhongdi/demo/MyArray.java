package com.dizhongdi.demo;

import java.util.Arrays;

public class MyArray {
    int a[];
    //用构造方法给数组赋大小
    public MyArray(int lenght) {
        a=new int[lenght];
    }
    public MyArray() {
        a=new int[0];
    }
    //删除指定下标的数组元素
    public void delete(int index){
        if (index>=a.length||index<0){
            throw new RuntimeException("要删除的元素超过了数组下标！！！");
        }
        int b[] = new int[a.length - 1];
        for (int i = 0; i < a.length; i++) {
            if (i == index) {
                continue;
            }else if (i < index) {
                b[i] = a[i];
            } else if (i > index) {
                b[i - 1] = a[i];
            }
        }
        a=b;
    }
    //向数组最后添加元素
    public void add(int element){
//        if (a.length==0){
//            int newarr [] = {element};
//            a=newarr;
//        }else {
            int newarr[] = new int[a.length + 1];
            for (int i = 0; i < a.length; i++) {
                newarr[i] = a[i];
            }
            newarr[newarr.length - 1] = element;
            a = newarr;
        }
//    }
    //返回数组长度
    public int size(){
        return a.length;
    }

    //输出所有的数组元素
    public void show() {
        System.out.println(Arrays.toString(a));
    }
    //给数组排序
    public void sort(){
        int temp;
        for (int i = a.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    //取出指定位置的某个元素
    public int get(int index){
        if (index>=a.length||index<0){
            throw new RuntimeException("数组下标越界！！！");
        }
        return a[index];
    }

    //替换指定位置的元素
    public void set(int index,int element){
        if (index>=a.length||index<0){
            throw new RuntimeException("数组下标越界！！！");
        }
        a[index]=element;
    }

    //插入某个元素到指定位置
    public void add(int element,int index ){
        if (index>=a.length||index<0){
            throw new RuntimeException("要删除的元素超过了数组下标！！！");
        }
        int newarr[] = new int[a.length+1];
        for (int i=0;i<newarr.length;i++){
            if (i==index){
                newarr[index]=element;
            }
            else if (i<index){
                newarr[i]=a[i];
            }
            else if (i>index){
                newarr[i]=a[i-1];
            }
        }
        a=newarr;
    }

    //线性查找
    public int search(int target){
        for (int i = 0; i<a.length;i++){
            if (a[i]==target){
                return i;
            }
        }
        return -1;
    }


    //二分查找
    public int binarySearch(int target){    //target：目标元素,返回目标元素的下标，-1表示不存在
        int begin = 0;  //开始元素
        int end = a.length-1;   //结束元素
        int mid = (end + begin)/2;                //中间的
        while (true){
            if (begin>=end){
                return -1;
            }
            if (a[mid]==target){
                return mid;
            }else {
                if (a[mid]>target){
                    end = mid-1;
                }else {
                    begin = mid+1;
                }
                mid = (end + begin)/2;

            }
        }

    }

}
