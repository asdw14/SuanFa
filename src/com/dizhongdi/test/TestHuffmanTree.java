package com.dizhongdi.test;

import com.dizhongdi.binaryTree.HuffmanTree;

/**
 * ClassName:TestHuffmanTree
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/2/6 19:28
 * @Author:dizhongdi
 */
public class TestHuffmanTree {
    public static void main(String[] args) {
        int arr[] = {3,7,8,29,5,11,23,14};
        HuffmanNode node = new HuffmanTree().createHuffman(arr);
        System.out.println(node.getValue());

    }
}
