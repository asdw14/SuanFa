package com.dizhongdi.binarySortTree;

/**
 * ClassName:TestBalanceBinaryTree
 * Package:com.dizhongdi.binarySortTree
 * Description:
 *
 * @Date: 2021/2/8 15:57
 * @Author:dizhongdi
 */
public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,1,5,9};
        BinarySortTree tree = new BinarySortTree();
        //循环添加节点
        for (int a:arr) {
            tree.add(new Node(a));
        }
        //删除节点
//        tree.delete(5);
//        //查看树中的值
//        tree.midShow();
//        tree.delete(3);
        tree.midShow();
        System.out.println("=--------------------------");
        tree.delete(3);
        tree.midShow();
//        Node node = tree.search(3);
//        System.out.println(node.value);

    }
}
