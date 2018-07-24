package com.example.demo.mylock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/5/28 14:15
 */
public class TicketLock {
    
    private AtomicInteger serviceNum=new AtomicInteger();
    
    private AtomicInteger ticketNum=new AtomicInteger();
    
    private static final ThreadLocal<Integer> local=new ThreadLocal<Integer>();
    
    public void lock(){
        String threadname=Thread.currentThread().getName();
        Integer num=ticketNum.getAndIncrement();
        System.out.println(num);
        local.set(num);
        while(num!=serviceNum.get()){
            System.out.println(threadname+",进入循环");
        }
        System.out.println(threadname+",lock complete");
    }
    
    public void unlock(){
        String threadname=Thread.currentThread().getName();
        Integer mynum=local.get();
        serviceNum.compareAndSet(mynum,mynum+1);
        System.out.println(threadname+",unlock complete");
    }


    public static void main(String[] args) {
        TicketLock ticketLock1=new TicketLock();
        
        ticketLock1.lock();
        System.out.println("---------------------");
        ticketLock1.lock();
    }
}
