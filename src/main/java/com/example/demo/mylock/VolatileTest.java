package com.example.demo.mylock;

public class VolatileTest {  
    public volatile int inc = 0;  
    public void increase() {  
        inc++;  
    }  
       
    public static void main(String[] args) {  
        final VolatileTest test = new VolatileTest();  
        for(int i=0;i<1000;i++){  
            new Thread(){  
                public void run() {  
                        test.increase();  
                };  
            }.start();  
        }  
           
        while(Thread.activeCount()>2) {  //保证前面的线程都执行完  
            System.out.println(Thread.activeCount());
            System.out.println(Thread.currentThread().getThreadGroup().getName());
            Thread.yield();
        }
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(test.inc);  
    }  
}