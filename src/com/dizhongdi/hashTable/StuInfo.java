package com.dizhongdi.hashTable;

/**
 * ClassName:StuInfo
 * Package:com.dizhongdi.hashTable
 * Description:
 *
 * @Date: 2021/2/10 17:27
 * @Author:dizhongdi
 */
public class StuInfo {
    private int age;
    private int value;

    public StuInfo(int age) {
        this.age = age;
    }

    /***
     * 散列函数
     * @return
     */
    public int hashCode() {
        return age%10;
    }
    /***
     * 散列函数2
     * @return
     */
    public int hashCode2() {
        return age;
    }
    @Override
    public String toString() {
        return "StuInfo{" +
                "age=" + age +
                ", value=" + value +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StuInfo(int age, int value) {
        this.age = age;
        this.value = value;
    }
}
