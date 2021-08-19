package com.dizhongdi.hashTable;

/**
 * ClassName:TestHashTable
 * Package:com.dizhongdi.hashTable
 * Description:
 *
 * @Date: 2021/2/10 17:28
 * @Author:dizhongdi
 */
public class TestHashTable {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(new StuInfo(16,3));
        hashTable.put(new StuInfo(17,6));
        hashTable.put(new StuInfo(18,5));
        hashTable.put(new StuInfo(19,7));
        hashTable.put(new StuInfo(20,4));
        hashTable.put(new StuInfo(30,4));
        System.out.println(hashTable.get(new StuInfo(17)));
        System.out.println(hashTable);
    }
}
