package com.dizhongdi.binaryTree;

/**
 * ClassName:TreeNode
 * Package:com.dizhongdi.binaryTree
 * Description:
 *      二叉树节点
 * @Date: 2021/2/2 19:05
 * @Author:dizhongdi
 */
public class TreeNode {
    private int value;
    //    左儿子
    private TreeNode leftNode;
    //    右儿子
    private TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //前序遍历
    public void frontShow(){
        //先遍历当前节点的内容
        System.out.println(this.value);
        //左节点
        if (leftNode!=null){
            leftNode.frontShow();
        }
        //右节点
        if (rightNode!=null){
            rightNode.frontShow();
        }
    }

    //中序遍历
    public void midShow() {
        //左节点
        if (this.leftNode!=null){
            this.leftNode.midShow();
        }
        //遍历当前节点的内容
        System.out.println(this.value);
        //右节点
        if (this.rightNode!=null){
            this.rightNode.midShow();
        }
    }
        //后序遍历
    public void afterShow() {
        //左节点
        if (this.leftNode!=null){
            this.leftNode.afterShow();
        }
        //右节点
        if (this.rightNode!=null){
            this.rightNode.afterShow();
        }
        //遍历当前节点的内容
        System.out.println(this.value);
    }

    //前序查找
    public TreeNode frontSearch(int i) {
        TreeNode temp = null;
//        对比当前节点的值
        if (this.value==i){
            return this;
        }
//        查找左儿子
        if (this.leftNode!=null){
//        又可能可以查到又可能查不到,查不到了temp还是个null
            temp = leftNode.frontSearch(i);
        }
//        查找右儿子
        if (temp==null){
            if (this.rightNode!=null){
                temp = rightNode.frontSearch(i);
            }
        }
//        所有元素已经遍历查找完了,所以不管有没有查到都返回
        return temp;
    }

//    删除子树
    public void delete(int i) {
        TreeNode parent = this;
        //判断左儿子
        if (parent.rightNode!=null&&parent.rightNode.getValue()==i){
            parent.rightNode =null;
            return;
        }
//        判断右儿子
        if (parent.leftNode!=null&&parent.leftNode.getValue()==i){
            parent.leftNode =null;
            return;
        }
//        都没找到递归检查下一层的左儿子并删除
        parent = rightNode;
        if (parent!=null){
            parent.delete(i);
        }
//        都没找到递归检查下一层的右儿子并删除
        parent = leftNode;
        if (parent!=null){
            parent.delete(i);
        }

//        TreeNode parent = this;
//        if (parent.rightNode!=null&&parent.rightNode.getValue()==i){
//            parent.rightNode = null;
//            return;
//        }
//        if (parent.leftNode!=null&&parent.leftNode.getValue()==i){
//            parent.leftNode = null;
//            return;
//        }
//        parent = rightNode;
//        if (rightNode!=null){
//            rightNode.delete(i);
//        }
//        parent = leftNode;
//        if (leftNode!=null){
//            leftNode.delete(i);
//        }

    }
}
