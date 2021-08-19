package com.dizhongdi.demo;

/**
 * ClassName:MyNode
 * Package:com.dizhongdi.demo
 * Description:
 *  实现单链表
 * @Date: 2021/1/20 19:29
 * @Author:dizhongdi
 */
public class MyNode {
    //节点内容
    int data;
    //下一个节点
    MyNode next;

    public MyNode(int data) {
        this.data = data;
    }

    //为节点追加下一个节点
    public MyNode append(MyNode next){
        //获取当前节点
        MyNode currentNode = this;
        while (true){
            //当下一个节点为空时，那么当前节点就是最后一个节点，跳出循环
            if (currentNode.next==null){
                currentNode.next = next;
                break;
            }
            //将下一个节点的地址赋给当前节点
            currentNode = currentNode.next;

        }
        return this;
    }

    //获取下一个节点
    public MyNode getNext(){
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

    //显示所有节点信息
    public void show(){
        MyNode currentNode = this;
        while (true){
            System.out.print(currentNode.data+" ");
            currentNode = currentNode.next;
            if (currentNode==null){
                break;
            }
        }
        System.out.println();
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(MyNode node){
        //把下一个节点赋给下下一个节点
        node.next=this.next;
        //把下一个节点替换成要插入的节点
        this.next=node;
    }

}
