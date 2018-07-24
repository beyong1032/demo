package com.example.demo.mylock;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

    public static void main(String[] strings){

        /***
         * 第三个测试示例：
         * 在第二个示例的基础上，将semaphore.acquire()和semaphore.release()的位置互换了一下
         * **/
        Semaphore semaphore = new Semaphore(0);
        for(int i=0; i<2; i++){
            System.out.println(i + "================" + i);
            System.out.println(semaphore.availablePermits());
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            System.out.println(i + "================" + i);
        }
        try {
            System.out.println("================");
            System.out.println(semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            System.out.println("================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}