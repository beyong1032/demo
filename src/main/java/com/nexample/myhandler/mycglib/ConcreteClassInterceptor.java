package com.nexample.myhandler.mycglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/8/2 13:35
 */
public class ConcreteClassInterceptor implements MethodInterceptor {
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before:"+method);
        Object object=methodProxy.invokeSuper(o, objects);
        System.out.println("After:"+method);
        return object;
    }
}
