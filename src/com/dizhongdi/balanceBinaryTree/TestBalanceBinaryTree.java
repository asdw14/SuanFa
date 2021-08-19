package com.dizhongdi.balanceBinaryTree;

/**
 * ClassName:TestBalanceBinaryTree
 * Package:com.dizhongdi.balanceBinaryTree
 * Description:
 *
 * @Date: 2021/2/9 17:03
 * @Author:dizhongdi
 */
public class TestBalanceBinaryTree {
    public static void main(String[] args) {
//        int[] arr = {8,9,6,7,5,4};
        int[] arr = {8,9,5,4,6,7};
        BalanceBinaryTree tree = new BalanceBinaryTree();
        //循环添加节点
        for (int a:arr) {
            tree.add(new Node(a));
        }
        System.out.println(tree.root.height());
        System.out.println(tree.root.leftHeight());
        System.out.println(tree.root.rightHeight());
        System.out.println(tree.root.value);
    }
}
