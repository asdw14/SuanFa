package com.dizhongdi.binaryTree;

/**
 * ClassName:ThreadedBinaryTree
 * Package:com.dizhongdi.binaryTree
 * Description:
 *  线索化二叉树
 * @Date: 2021/2/6 16:46
 * @Author:dizhongdi
 */
public class ThreadedBinaryTree {
    //根节点
    ThreadedNode root;

    //用于临时储存前驱节点
    ThreadedNode pre;
    public ThreadedNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    public void threadNodes(){
        threadNodes(root);
    }
    //中序线索化二叉树
    public void threadNodes(ThreadedNode node){
        if (node==null){
            return;
        }
        //处理左子树
        threadNodes(node.getLeftNode());
        //处理前驱节点
        if (node.getLeftNode()==null){
            //让当前的节点指向前驱节点
            node.setLeftNode(pre);
            //改变当前节点左指针的类型
            node.setLeftType(1);
        }
        //处理前驱节点的右指针，如果前驱节点的右指针为null（没有保存右指针）
        if (pre != null && pre.getRightNode() == null){
            //让前驱节点的右指针指向当前节点
            pre.setRightNode(node);
            //改变当前节点右指针的类型
            pre.setRightType(1);
        }
        pre = node;
        //处理右子树
        threadNodes(node.getRightNode());

    }

    //遍历线索二叉树
    public void threadedIterate(){
        //用于临时存储当前遍历节点
        ThreadedNode node = root;
        //循环找到最开始的节点
        while (node.getLeftType()==0){
            node = node.getLeftNode();
        }
        while (node!=null){
            //打印当前节点的值
            System.out.println(node.getValue());
            //如果当前节点的右指针指向的是后继节点，可能后继节点后还有后继节点
            while (node.getRightType()==1){
                node=node.getRightNode();
                System.out.println(node.getValue());
            }
            //替换遍历的节点
            node= node.getRightNode();
        }
    }


    public void midShow() {
        if(root!=null) {
            root.midShow();
        }
    }

    public void frontShow() {
        if(root!=null) {
            root.frontShow();
        }
    }

    public void afterShow() {
        if(root!=null) {
            root.afterShow();
        }
    }

    public ThreadedNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    //删除子树
    public void delete(int i) {
        if (root!=null){
        if (root.getValue()==i){
            root = null;
            return;
        }else {
            root.delete(i);
        }
        }
    }
}
