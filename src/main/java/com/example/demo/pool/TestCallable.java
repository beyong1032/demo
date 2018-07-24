package com.example.demo.pool;

import javax.sound.midi.Soundbank;
import java.util.concurrent.*;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/6/4 12:52
 */
public class TestCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return 123;
    }

    public static void main(String[] args) {
        TestCallable tc=new TestCallable();
        ExecutorService executors=Executors.newFixedThreadPool(3);
        Future future=executors.submit(tc);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
