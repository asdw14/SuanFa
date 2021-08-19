package com.dizhongdi.binaryTree;

import com.dizhongdi.test.HuffmanNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:HuffmanTree
 * Package:com.dizhongdi.binaryTree
 * Description:
 *  哈夫曼树
 * @Date: 2021/2/6 19:28
 * @Author:dizhongdi
 */
public class HuffmanTree {
    public HuffmanNode createHuffman(int[] arr) {

        //用数组中所有的元素创建若干个二叉树，（只有一个节点）
        List<HuffmanNode> nodes= new ArrayList<>();
        for (int value:arr) {
            nodes.add(new HuffmanNode(value));
        }
        //循环处理
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出权值最小的两个二叉树
            //取出权值最小的二叉树
            HuffmanNode left = nodes.get(nodes.size()-1);
            //取出权值次小的二叉树
            HuffmanNode right = nodes.get(nodes.size()-2);
            //创建一颗新的二叉树
            HuffmanNode parent = new HuffmanNode(left.getValue()+right.getValue());
            parent.setLeft(left);
            parent.setLeft(right);
            //把取出来的两个二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树集合中
            nodes.add(parent);
        }

        return nodes.get(0);
    }
}
