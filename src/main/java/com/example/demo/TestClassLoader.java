package com.example.demo;

import java.io.File;
import java.net.URL;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/4/19 10:32
 */
public class TestClassLoader {

    public static void main(String[] args) {
        ClassLoader c=TestClassLoader.class.getClassLoader();
        while(c!=null){
            System.out.println(c+"----"+c.getParent());
            c=c.getParent();
        }
        System.out.println("==============================================");
        // 也可通过 System.getProperty("sun.boot.class.path" 获取
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        System.out.println("==============================================");

        String paths = System.getProperty("java.ext.dirs");

        String [] pathList = paths.split(File.pathSeparator);

        for(String path : pathList) {
            System.out.println(path);
        }
        System.out.println("==============================================");
        String paths2 = System.getProperty("java.class.path");

        String [] pathList2 = paths2.split(File.pathSeparator);

        for(String path : pathList2) {
            System.out.println(path);
        }
    }
}
