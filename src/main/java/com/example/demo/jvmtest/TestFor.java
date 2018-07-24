package com.example.demo.jvmtest;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/6/12 11:26
 */
public class TestFor {

    public void poll() {
        // 设置起始点  
        restartFromHead:
        for (int i=0;i<10;i++) {
               if (i == 8) {
                   System.out.println("restartFromHead");
                   // 这个一般是删完了(有点模糊)  
                   continue restartFromHead;
               }else {
                   System.out.println(i);
               }
        }
    }

    public static void main(String[] args) {
        TestFor testFor=new TestFor();
        testFor.poll();
    }
}
