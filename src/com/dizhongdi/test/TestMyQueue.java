package com.dizhongdi.test;

import com.dizhongdi.demo.MyQueue;

/**
 * ClassName:TestMyQueue
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/1/20 19:21
 * @Author:dizhongdi
 */
public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(10);
        myQueue.add(12);
        myQueue.add(13);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}
