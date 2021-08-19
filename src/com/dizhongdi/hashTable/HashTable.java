package com.dizhongdi.hashTable;

import java.util.Arrays;

/**
 * ClassName:HashTable
 * Package:com.dizhongdi.hashTable
 * Description:
 *  哈希表数据结构
 *  解决散列冲突：开放地址法：再哈希法
 * @Date: 2021/2/10 17:27
 * @Author:dizhongdi
 */
public class HashTable {
    StuInfo[] data = new StuInfo[100];
    public void put(StuInfo stu){
        //调用散列函数获取存储位置
        int index = stu.hashCode();
        //添加元素
        //如果要存的位置为空，那么直接放
        if (data[index]==null){
            data[index] = stu;
        }
        //要存的位置不为空，那么存储在散列函数2的位置
        else {
            index = stu.hashCode2();
            data[index] = stu;
        }
    }
    public StuInfo get(StuInfo stu){
        return data[stu.hashCode()];
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
