package com.example.demo.mylock;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/6/27 15:33
 */
public class LockTest implements Runnable{
    
    private static ReentrantLock lock=new ReentrantLock();
    
    private static int a;

    @Override
    public void run() {
        try {
            lock.lock();
            a++;
            System.out.println(Thread.currentThread().getName() + "\t" + a);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(10);
        for(int i=0;i<9;i++){
            executor.execute(new LockTest());
        }
    }
}
