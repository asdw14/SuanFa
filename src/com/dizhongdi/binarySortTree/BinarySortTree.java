package com.dizhongdi.binarySortTree;


/**
 * ClassName:BinarySortTree
 * Package:com.dizhongdi.binarySortTree
 * Description:
 *  二叉排序树
 * @Date: 2021/2/8 15:45
 * @Author:dizhongdi
 */
public class BinarySortTree {
    Node root;

    /**
     *  向二叉排序树中添加节点
     * @param node
     */
    public void add(Node node){
        if (root==null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void midShow() {
        if (root!=null){
            root.midShow(root);
        }
    }

    /**
     * 节点的查找
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root==null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public void delete(int value) {
        if (root!=null){
            //找到这个节点
            Node targe = root.search(value);
            if (targe==null){
                return;
            }
            //找到他的父节点
            Node parent = serarchParent(value);
            //如果这个节点是叶子节点，直接删除
            if (targe.left==null&&targe.right==null){
                //要删除的节点是父节点的左子节点
                if (parent.left==targe){
                    parent.left=null;
                }
                //要删除的节点是父节点的右子节点
                if (parent.right==targe){
                    parent.right=null;
                }
            }

            //要删除的节点有两个子节点
            else if (targe.left!=null&&targe.right!=null){
                //删除右子树中值最小的节点，即获取到该节点的值
                int min = deleteMin(targe.right);
                //替换目标节点中的值
                targe.value = min;
            }
            //要删除的节点只有一棵左节点或右节点
            else {
                //有一个左节点
                if (targe.left!=null) {
                    //要删除的节点是父节点的左子节点
                    if (parent.left == targe) {
                        parent.left = targe.left;
                    }
                    //要删除的节点是父节点的右子节点
                    if (parent.right == targe) {
                        parent.right = targe.left;
                    }
                }
            //有一个右节点
            if (targe.right!=null) {
                //要删除的节点是父节点的左子节点
                if (parent.left == targe) {
                    parent.left = targe.right;
                }
                //要删除的节点是父节点的右子节点
                if (parent.right == targe) {
                    parent.right = targe.right;
                }
            }
            }
        }
    }

    /**
     * 删除一棵树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node targe = node;
        //递归向左找
        while (targe.left!=null){
            targe = targe.left;
        }
        int temp = targe.value;
        //删除最小的节点
        delete(targe.value);
        return temp;
    }

    /**
     * 搜索父节点
     * @param value
     */
    private Node serarchParent(int value) {
        if (root!=null){
            return root.serarchParent(value);
        }
        return null;
    }
}
