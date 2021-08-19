package com.dizhongdi.test;

import com.dizhongdi.binaryTree.ThreadedBinaryTree;
import com.dizhongdi.binaryTree.ThreadedNode;

/**
 * ClassName:TestThreadBinaryNode
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/2/6 17:15
 * @Author:dizhongdi
 */
public class TestThreadBinaryNode {
    public static void main(String[] args) {
        ThreadedNode root = new ThreadedNode(1);
        ThreadedBinaryTree tbTree = new ThreadedBinaryTree();
        tbTree.setRoot(root);
        ThreadedNode rootL = new ThreadedNode(2);
        root.setLeftNode(rootL);
        ThreadedNode rootR = new ThreadedNode(3);
        root.setRightNode(rootR);
        rootL.setLeftNode(new ThreadedNode(4));
        ThreadedNode node5 = new ThreadedNode(5);
        rootL.setRightNode(node5);
        rootR.setLeftNode(new ThreadedNode(6));
        rootR.setRightNode(new ThreadedNode(7));
        //中序遍历
        tbTree.midShow();
        //中序线索化二叉树
        tbTree.threadNodes();
//        System.out.println(node5.getRightNode().getValue());
        System.out.println("---------------------------------------");
        tbTree.threadedIterate();
    }
}
