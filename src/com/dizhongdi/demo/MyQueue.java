package com.dizhongdi.demo;

/**
 * ClassName:MyQueue
 * Package:com.dizhongdi.demo
 * Description:
 *  实现队列数据结构
 * @Date: 2021/1/20 19:12
 * @Author:dizhongdi
 */
public class MyQueue {
    int elements[];
    public MyQueue() {
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
