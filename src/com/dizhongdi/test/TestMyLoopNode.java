package com.dizhongdi.test;

import com.dizhongdi.demo.MyLoopNode;

/**
 * ClassName:TestMyLoopNode
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/1/21 20:02
 * @Author:dizhongdi
 */
public class TestMyLoopNode {
    public static void main(String[] args) {
        MyLoopNode lp1 = new MyLoopNode(1);
        MyLoopNode lp2 = new MyLoopNode(2);
        MyLoopNode lp3 = new MyLoopNode(3);
        MyLoopNode lp4 = new MyLoopNode(4);
        lp1.after(lp2);
        lp2.after(lp3);
        lp3.after(lp4);
        System.out.println(lp1.getNext().getData());
        System.out.println(lp2.getNext().getData());
        System.out.println(lp3.getNext().getData());
        System.out.println(lp4.getNext().getData());
    }
}
