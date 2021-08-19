package com.dizhongdi.test;

import com.dizhongdi.binaryTree.ArrayBinaryTree;

/**
 * ClassName:TestArrayBinaryTree
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/2/2 21:55
 * @Author:dizhongdi
 */
public class TestArrayBinaryTree {
    public static void main(String[] args) {
        ArrayBinaryTree abTree = new ArrayBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        abTree.frontShow();
    }
}
