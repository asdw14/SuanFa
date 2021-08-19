package com.dizhongdi.graph;

import java.util.Arrays;

/**
 * ClassName:TestGraph
 * Package:com.dizhongdi.graph
 * Description:
 *
 * @Date: 2021/2/11 14:25
 * @Author:dizhongdi
 */
public class TestGraph {
    public static void main(String[] args) {
        Vertex vq1 = new Vertex("A");
        Vertex vq2 = new Vertex("B");
        Vertex vq3 = new Vertex("C");
        Vertex vq4 = new Vertex("D");
        Vertex vq5 = new Vertex("E");
        Graph g = new Graph(5);
        g.addVertex(vq1);
        g.addVertex(vq2);
        g.addVertex(vq3);
        g.addVertex(vq4);
        g.addVertex(vq5);

        //增加边
        g.addEdge("A","C");
        g.addEdge("B","C");
        g.addEdge("A","B");
        g.addEdge("B","D");
        g.addEdge("B","E");

        for (int[] a:g.adgmat){
            System.out.println(Arrays.toString(a));
        }
        //深度优先遍历
        g.dfs();
    }
}
