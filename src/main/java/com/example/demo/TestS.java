package com.example.demo;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/4/13 13:59
 */
public class TestS implements Runnable{
    
    
    public static synchronized void m1(){
        System.out.println(11111+Thread.currentThread().getName());
    }

    public static synchronized void m2(){
        System.out.println(2222+Thread.currentThread().getName());
        m1();
    }

    public int hash(Object key) {
        int h;
        System.out.println(key.hashCode());
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        TestS t=new TestS();
//        TestS t2=new TestS();
//        new Thread(t).start();
//        new Thread(t2).start();

        System.out.println(t.hash("a"));
        System.out.println(t.hash(97));

        System.out.println( (16 >>> 2));
        System.out.println( 16 - (16 >>> 2));
    }

    @Override
    public void run() {
        m2();
    }
}
