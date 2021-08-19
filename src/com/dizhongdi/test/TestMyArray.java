package com.dizhongdi.test;

import com.dizhongdi.demo.MyArray;

public class TestMyArray {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        System.out.println(myArray.size());
        myArray.add(65);
        myArray.add(66);
        myArray.add(68);
        myArray.add(69);
//        myArray.show();
//        System.out.println(myArray.size());
//        myArray.add(60,0);
//        myArray.show();
//        System.out.println(myArray.size());
        myArray.add(70);
//        myArray.set(2,20);
        myArray.show();
        myArray.sort();
        myArray.show();
        System.out.println(myArray.binarySearch(68));
//        myArray.delete(0);
//        myArray.show();
//        System.out.println(myArray.get(0));
    }
}
