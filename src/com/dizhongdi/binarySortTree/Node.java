package com.dizhongdi.binarySortTree;

/**
 * ClassName:Node
 * Package:com.dizhongdi.binarySortTree
 * Description:
 *  二叉排序树的节点
 * @Date: 2021/2/8 15:46
 * @Author:dizhongdi
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 向子树中添加节点
     * @param node
     */
    public void add(Node node) {
        if (node==null){
            return;
        }
        //判断传入的节点的值比当前子树的根节点的值小还是大
        //添加的节点比当前节点小
        if (node.value<this.value){
            if (this.left==null){
                this.left=node;
            }
            //当前节点的左节点不为空
            else {
                this.left.add(node);
            }
            //添加的节点比当前节点大
        }else if (node.value>this.value){
            if (this.right==null){
                this.right=node;
            }
            //当前节点的左节点不为空
            else {
                this.right.add(node);
            }
            }
    }

    //中序遍历
    public void midShow(Node node) {
        if (node==null) {
            return;
        }
        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);

    }

    /**
     * 查找节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value){
            return this;
        }
        if (value<this.value&&this.left!=null){
            return this.left.search(value);
        }else if (value>this.value&&this.right!=null){
            return this.right.search(value);
        }
        return null;
    }

    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public Node serarchParent(int value) {
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            if (value<this.value&&this.left!=null){
                return this.left.serarchParent(value);
            }else if (value>this.value&&this.right!=null){
                return this.right.serarchParent(value);
            }
        }
        return null;
    }
}
