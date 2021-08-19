package com.dizhongdi.test;

import com.dizhongdi.demo.DoubleNode;

/**
 * ClassName:TestDoubleNode
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/1/23 19:32
 * @Author:dizhongdi
 */
public class TestDoubleNode {
    public static void main(String[] args) {
        DoubleNode dn1 = new DoubleNode(1);
        DoubleNode dn2 = new DoubleNode(2);
        DoubleNode dn3 = new DoubleNode(3);
        dn1.after(dn2);
        dn2.after(dn3);
        System.out.println(dn1.getNext().getData());
        System.out.println(dn2.getNext().getData());
        System.out.println(dn3.getNext().getData());
        System.out.println(dn1.getPre().getData());
    }
}
