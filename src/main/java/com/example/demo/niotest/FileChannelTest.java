package com.example.demo.niotest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/6/6 13:09
 */
public class FileChannelTest {

    public static void main(String[] args) {
        try {
            RandomAccessFile af1=new RandomAccessFile("f:\\a.txt","rw");
            FileChannel fc1=af1.getChannel();

            RandomAccessFile af2=new RandomAccessFile("f:\\b.txt","rw");
            FileChannel fc2=af2.getChannel();
            
            int p=0;
            long count=fc1.size();
            
            fc2.transferTo(p,count,fc1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
