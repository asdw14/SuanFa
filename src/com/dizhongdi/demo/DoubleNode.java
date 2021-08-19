package com.dizhongdi.demo;

/**
 * ClassName:DoubleNode
 * Package:com.dizhongdi.demo
 * Description:
 *  双向链表
 * @Date: 2021/1/21 20:10
 * @Author:dizhongdi
 */
public class DoubleNode {
    //上一个节点
    DoubleNode pre = this;


    //下一个节点
    DoubleNode next = this;
    //节点数据
    private int data;

    public DoubleNode(int data) {
        this.data = data;
    }

    public DoubleNode getPre() {
        return this.pre;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public void after(DoubleNode node){
        //获取当前节点的下一个节点，被插入新节点后就变成下下个节点
        DoubleNode nextNext = next;
        //把下一个节点赋给新节点的下一个节点
        node.next=this.next;
        //把当前节点赋给下一个节点的上一个节点
        node.pre=this;
        //把要插入的节点赋给当前节点的下一个节点
        this.next=node;
        //把插入进的节点赋给下下一个节点的上一个节点
        nextNext.pre=node;
    }









}
