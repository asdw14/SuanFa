package com.dizhongdi.demo;

/**
 * ClassName:MyLoopNode
 * Package:com.dizhongdi.demo
 * Description:
 *  实现循环链表
 * @Date: 2021/1/21 19:45
 * @Author:dizhongdi
 */
public class MyLoopNode {
    //节点内容
    int data;
    //下一个节点
    MyLoopNode next = this;

    public MyLoopNode(int data) {
        this.data = data;
    }


    //获取下一个节点
    public MyLoopNode getNext(){
        return this.next;
    }

    //删除下一个节点
    public void removeNext(){
        if (this.next!=null) {
            //把下下一个节点设置成当前节点的下一个节点
            this.next = this.next.getNext();
        }
    }

    //获取下一个节点
    public int getData(){
        return this.data;
    }

    //判断当前节点是否为最后一个节点
    public boolean isLast(){
        return next == null ? true : false;
    }


    //插入一个节点作为当前节点的下一个节点
    public void after(MyLoopNode node){
        //把下一个节点赋给下下一个节点
        node.next=this.next;
        //把下一个节点替换成要插入的节点
        this.next=node;
    }

}
