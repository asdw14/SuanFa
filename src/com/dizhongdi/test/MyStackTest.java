package com.dizhongdi.test;

import com.dizhongdi.demo.MyStack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.isEmpty());
        myStack.push(111);
        System.out.println(myStack.isEmpty());
        myStack.push(222);
        myStack.push(3333);
        myStack.push(444);
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }
}
