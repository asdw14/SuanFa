package com.dizhongdi.test;

import com.dizhongdi.binaryTree.BinaryTree;
import com.dizhongdi.binaryTree.TreeNode;

/**
 * ClassName:TestBinaryTree
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/2/2 19:04
 * @Author:dizhongdi
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        //根节点
        TreeNode root = new TreeNode(1);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        //创建一个左节点
        TreeNode rootL = new TreeNode(2);
        //创建一个右节点
        TreeNode rootR = new TreeNode(3);
//        把新创建的节点设置成跟节点的子节点
        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        //为第二层的左节点创建两个子节点
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));
        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));
        //前序遍历
        binaryTree.frontShow();
        System.out.println("==========================");
//        //中序遍历
//        binaryTree.midShow();
//        System.out.println("==========================");
        //后序遍历
//        binaryTree.afterShow();
//        binaryTree.frontSearch(1);
        //前序查找
//        TreeNode treeNode = binaryTree.frontSearch(4);
//        System.out.println(treeNode.getValue());
        binaryTree.delete(3);
        binaryTree.frontShow();


    }
}
