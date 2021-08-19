package com.dizhongdi.test;

import java.io.IOException;
public class Test01 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        String dizhongdi = Thread.currentThread().getContextClassLoader().getResource("dizhongdi").getPath();
//        System.out.println(dizhongdi);
//        File file = new File("D:\\IdeaProjects\\SuanFa\\out\\production\\dizhongdi");
//        file.delete();
        TestThread testThread = new TestThread();

        Thread t1 = new Thread(testThread);
        t1.setName("Thread1");
        TestThread2 t0 = new TestThread2();
        t0.setDaemon(true);//将线程设置成守护线程
        t0.start();
        System.out.println(t1.getName());
        t1.setPriority(10);
        Thread t2 = new Thread(testThread);
        t2.setPriority(1);
        Thread t3 = new Thread(testThread);
        t3.setPriority(1);
        Thread t4 = new Thread(testThread);
        t4.setPriority(1);
        t1.start();
        t2.start();
        t4.start();
        t3.start();
    }
}
class TestThread2 extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println(0000000);
        }
    }
}
class TestThread implements Runnable{
    @Override
   synchronized public void run() {
            System.out.println("11111");
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            System.out.println("2222");

            System.out.println("3333");
            System.out.println("444444");

    }
}
