package com.nexample.myhandler.myjdk;

import java.lang.reflect.*;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/8/2 11:33
 */
public class MyJdkHandler {
    
    public static void testProxy(){
        //    我们要代理的真实对象
        Subject realSubject = new RealSubject();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }
    
    public static void testReflect(RealSubject realSubject) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz=realSubject.getClass();
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
            field.setAccessible(true);
            if("name".equals(field.getName())) {
                field.set(realSubject, "张三");
            }
            if("age".equals(field.getName())) {
                field.set(realSubject, 18);
            }
        }
        Method setname=clazz.getMethod("setName",String.class);
        setname.invoke(realSubject,"李四");
        Method setage=clazz.getMethod("setAge",int.class);
        setage.invoke(realSubject,25);
    }
    
    public static void main(String[] args)
    {
        testProxy();
//        try {
//            RealSubject realSubject=new RealSubject();
//            testReflect(realSubject);
//            System.out.println(realSubject.getName()+":"+realSubject.getAge());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }
}
