package com.dizhongdi.haffmanCode;

/**
 * ClassName:Node
 * Package:com.dizhongdi.haffmanCode
 * Description:
 *
 * @Date: 2021/2/6 21:39
 * @Author:dizhongdi
 */
public class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return o.weight-this.weight;
    }
}
