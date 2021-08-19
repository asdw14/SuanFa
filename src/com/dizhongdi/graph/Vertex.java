package com.dizhongdi.graph;

/**
 * ClassName:Vertex
 * Package:com.dizhongdi.graph
 * Description:
 *  图结构的顶点类
 * @Date: 2021/2/11 11:12
 * @Author:dizhongdi
 */
public class Vertex {
    String value;
    public boolean visited;
    public Vertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
