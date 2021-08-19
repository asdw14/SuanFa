package com.dizhongdi.demo;

public class MyStack {
    int elements[];
    public MyStack(){
        elements = new int[0];
    }

    //压栈
    public void push(int element){
        int newarr[] = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newarr[i] = elements[i];
        }
        newarr[newarr.length - 1] = element;
        elements = newarr;
    }

    //弹栈
    public int pop(){
        //如果栈空了抛异常
        if (elements.length<=0){
            throw new RuntimeException("栈已空");
        }
        //取出最顶部的元素
        int element = elements[elements.length-1];
        int newarr[] = new int[elements.length - 1];

        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = elements[i];
        }
        elements=newarr;
        //返回栈顶部的元素
        return element;
    }

    //查看栈顶部的元素
    public int peek(){
        return elements[elements.length-1];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
