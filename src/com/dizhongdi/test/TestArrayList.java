package com.dizhongdi.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName:TestArrayList
 * Package:com.dizhongdi.test
 * Description:
 *
 * @Date: 2021/2/15 20:26
 * @Author:dizhongdi
 */
public class TestArrayList {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(199999);
        System.out.println(c.contains(199999));
    }
}
