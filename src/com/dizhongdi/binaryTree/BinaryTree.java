package com.dizhongdi.binaryTree;

/**
 * ClassName:BinaryTree
 * Package:com.dizhongdi.binaryTree
 * Description:
 *  二叉树
 * @Date: 2021/2/2 19:04
 * @Author:dizhongdi
 */
public class BinaryTree {
    //根节点
    TreeNode root;
    //获取根节点
    public TreeNode getRoot() {
        return root;
    }
    //设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //前序遍历
    public void midShow() {
        if(root!=null) {
            root.midShow();
        }
    }
    //中序遍历
    public void frontShow() {
        if(root!=null) {
            root.frontShow();
        }
    }
    //后序遍历
    public void afterShow() {
        if(root!=null) {
            root.afterShow();
        }
    }

    //前序查找
    public TreeNode frontSearch(int i) {
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
