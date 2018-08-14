package com.nexample.myatomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABA {
        private static AtomicInteger atomicInt = new AtomicInteger(100);
        private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(100, 0);
        private static CountDownLatch countDownLatch=new CountDownLatch(2);

        public static void main(String[] args) throws InterruptedException {
                Thread intT1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                System.out.println("intT1 begin");
                                atomicInt.compareAndSet(100, 101);
                                atomicInt.compareAndSet(101, 100);
                                countDownLatch.countDown();
                        }
                });

                Thread intT2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                try {
                                        TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                }
                                System.out.println("intT2 begin");
                                boolean c3 = atomicInt.compareAndSet(100, 101);
                                System.out.println(c3); // true
                                countDownLatch.countDown();
                        }
                });

                intT1.start();
                intT2.start();
                countDownLatch.await();

                Thread refT1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                try {
                                        TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                }
                                System.out.println("refT1 begin");
                                System.out.println("Stamp "+atomicStampedRef.getStamp());
                                atomicStampedRef.compareAndSet(100, 101, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                                System.out.println("Stamp "+atomicStampedRef.getStamp());
                                atomicStampedRef.compareAndSet(101, 100, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                                System.out.println("Stamp "+atomicStampedRef.getStamp());
                        }
                });

                Thread refT2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                int stamp = atomicStampedRef.getStamp();
                                try {
                                        TimeUnit.SECONDS.sleep(2);
                                } catch (InterruptedException e) {
                                }
                                System.out.println("refT2 begin");
                                System.out.println("Stamp "+stamp);
                                boolean c3 = atomicStampedRef.compareAndSet(100, 101, stamp, stamp + 1);
                                System.out.println("Stamp "+atomicStampedRef.getStamp());
                                System.out.println(c3); // false
                        }
                });

                refT1.start();
                refT2.start();
        }
}