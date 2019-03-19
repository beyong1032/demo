package com.example.demo.mylock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/5/28 13:49
 */
public class SpinLock {
    
    private AtomicReference<Thread> spin=new AtomicReference<Thread>();

    private AtomicReference<String> strtest=new AtomicReference<String>();
    
    public void lock(){
        System.out.println(spin.get());
        Thread current=Thread.currentThread();
//        boolean flag=spin.compareAndSet(null,current);
//        System.out.println(flag);
        while(!spin.compareAndSet(null,current)){
            
        }
        
    }
    
    public void testString(){
        String test1="my first";
        strtest.set(test1);
        String test2="my second";
        boolean exchange=strtest.compareAndSet(test2,test1);
        System.out.println(exchange);
        exchange=strtest.compareAndSet(test1,test2);
        System.out.println(exchange);
    }
    
    public void unlock(){
        Thread current=Thread.currentThread();
        spin.compareAndSet(current,null);
    }

    public static void main(String[] args) {
        SpinLock spinLock=new SpinLock();
        spinLock.lock();
        System.out.println("-----------------");
        spinLock.testString();
    }
}
