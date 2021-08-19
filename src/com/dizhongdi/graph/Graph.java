package com.dizhongdi.graph;

import com.dizhongdi.demo.MyStack;

/**
 * ClassName:Graph
 * Package:com.dizhongdi.graph
 * Description:
 *  图结构
 * @Date: 2021/2/11 11:11
 * @Author:dizhongdi
 */
public class Graph {
    private Vertex[] vertex;
    private int currentSize = 0;
    public int[][] adgmat;
    private MyStack stack = new MyStack();
    //当前遍历的下标
    int currentIndex;


    public Graph(int size) {
        vertex = new Vertex[size];
        adgmat = new int[size][size];
    }

    /**
     * 像图中加入一个顶点
     *
     * @param v
     */
    public void addVertex(Vertex v) {
        vertex[currentSize++] = v;
    }

    /**
     * 给元素添加边
     * @param s1
     * @param s2
     */
    public void addEdge(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        //找出两个顶点的下标
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(s1)) {
                index1 = i;
                break;
            }
        }
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(s2)) {
                index2 = i;
                break;
            }
        }
        adgmat[index1][index2] = 1;
        adgmat[index2][index1] = 1;
    }

    /**
     * 深度优先算法遍历图
     */
    public void dfs(){
        //把第0个顶点标记为已访问状态
        vertex[0].visited=true;
        //把第0个顶点的下标放入栈
        stack.push(0);
        System.out.println(vertex[0].value);
        //遍历
        out:while (!stack.isEmpty()) {
            for (int i = currentIndex + 1; i < vertex.length; i++) {
                //如果和下一个遍历的元素是通的
                if (adgmat[currentIndex][i] == 1 && vertex[i].visited == false) {
                    //把下一个元素压入栈中
                    stack.push(i);
                    vertex[i].visited = true;
                    System.out.println(vertex[i].getValue());
                    continue out;
                }
            }
            //弹出栈顶元素
            stack.pop();
            //修改当前位置为栈顶元素的位置
            if (!stack.isEmpty()) {
                currentIndex = stack.peek();
            }
        }
    }
}
