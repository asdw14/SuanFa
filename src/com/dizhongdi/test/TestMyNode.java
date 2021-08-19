package com.dizhongdi.test;

import com.dizhongdi.demo.MyNode;

/**
 * ClassName:TestMyNode
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/1/20 19:36
 * @Author:dizhongdi
 */
public class TestMyNode {
    public static void main(String[] args) {
        //创建节点
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        //追加节点
        node1.append(node2).append(node3).append(new MyNode(4));
        node1.show();
//        node1.getNext().removeNext();
        node1.after(new MyNode(6));
        node1.show();
        //取出下一个节点
//        System.out.println(node1.getNext().getNext().getData());
//        System.out.println(node1.isLast());
//        System.out.println(node1.getNext().getNext().isLast());

    }
}
