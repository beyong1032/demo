package com.example.demo.mylock;

public class Producer extends Thread{
        
        public void run(){
            for(int i=0;i<5;i++){
                System.out.println("I am producer"+i);
                Thread.yield();
            }
        }
    }