package com.dizhongdi.balanceBinaryTree;

/**
 * ClassName:Node
 * Package:com.dizhongdi.balanceBinaryTree
 * Description:
 *  平衡二叉排序树的节点
 * @Date: 2021/2/9 17:03
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
        //查询是否平衡
        //进行右旋转
        if (leftHeight()-rightHeight()>=2){
            //双旋转
            if (left!=null&&left.leftHeight()<left.rightHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                //单旋转
                rightRotate();
            }
        }
        //进行左旋转
        if (rightHeight()-leftHeight()>=2){
            //双旋转
            if (right.leftHeight()< right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                //单旋转
                leftRotate();
            }

        }
    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        //创建一个新的节点，值等于当前节点的值
        Node newLeft = new Node(value);
        //把新节点的左子树设置为当前节点的左子树
        newLeft.left = left;
        newLeft.right = left.left;
        value=right.value;
        right = right.right;
        left = newLeft;
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        //创建一个新的节点，值等于当前节点的值
        Node newRight = new Node(value);
        //把新节点的右子树设置为当前节点的右子树
        newRight.right = right;
        //把新节点的左子树设置为当前节点的左子树的右子树
        newRight.left = right.right;
        //把当前节点的值换为当前节点的左子树的值
        value=left.value;
        //把当前节点的左子树设置为当前节点的左子树的左子树
        left = left.left;
        //把当前节点的右子树设置为新节点
        right = newRight;
    }

    /**
     * 获取左子树的高度
     * @return
     */
    public int leftHeight() {
        if (left==null){
            return 0;
        }
        return left.height();
    }

    /**
     * 获取右子树的高度
     * @return
     */
    public int rightHeight() {
        if (right==null){
            return 0;
        }
        return right.height();}

    /**
     * 获取高度
     * @return
     */
    public int height() {
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
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
