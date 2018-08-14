package com.nexample.myhandler.mycglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/8/2 13:37
 */
public class MyCglib {

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(ConcreteClassNoInterface.class);
        enhancer.setCallback(new ConcreteClassInterceptor());
        ConcreteClassNoInterface  ccni=(ConcreteClassNoInterface)enhancer.create();
        ccni.getConcreteMethodA("test");
        ccni.getConcreteMethodB(123);
    }
}
