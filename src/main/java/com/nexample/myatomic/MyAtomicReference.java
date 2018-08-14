package com.nexample.myatomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/8/1 13:54
 */
public class MyAtomicReference {
    
        private static int threadCount=10;
        private static CountDownLatch countDown=new CountDownLatch(threadCount);
        public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();
        private static class ReferenceUpdater implements Runnable{
            User user;
            public ReferenceUpdater(User user){
                this.user=user;
            }
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    User oldUser=atomicUserRef.get();
                    atomicUserRef.compareAndSet(oldUser, user);
                    Thread.yield();
                }
                countDown.countDown();
            }
        }
        public static void main(String[] args) throws InterruptedException {
            Thread[] threads=new Thread[threadCount];
            for(int i=0;i<threadCount;i++){
                threads[i]=new Thread(new ReferenceUpdater(new User("name"+i,i)));
            }
            for(int i=0;i<threadCount;i++){
                threads[i].start();;
            }
            countDown.await();
            System.out.println(atomicUserRef.get().getName());
            System.out.println(atomicUserRef.get().getOld());
        }

        static class User {
            private String name;
            private int old;

            public User(String name, int old) {
                this.name = name;
                this.old = old;
            }

            public String getName() {
                return name;
            }

            public int getOld() {
                return old;
            }
        }

}
