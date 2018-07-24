package com.example.demo.mylock;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/5/29 14:37
 */
public class YieldTest {

    public static void main(String[] args) {
        Thread producer=new Producer();
        Thread consumer=new Consumer();

        producer.setPriority(Thread.MAX_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MIN_PRIORITY); //Max Priority
        
        producer.start();
        consumer.start();
    }
    

}
