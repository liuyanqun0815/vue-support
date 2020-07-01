package com.example.vuesupport.postFactory.mybatis;

import com.alibaba.fastjson.JSON;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/26
 */
    public class ServiceProxy<T> implements InvocationHandler {

    private Class <T> interfaceType;
    public ServiceProxy(Class<T> interfaceType){
        this.interfaceType = interfaceType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this,args);
        }
//        method.invoke(this,args);
        System.out.println("调用前，参数：{}" + args);
        //这里可以得到参数数组和方法等，可以通过反射，注解等，进行结果集的处理
        //mybatis就是在这里获取参数和相关注解，然后根据返回值类型，进行结果集的转换
        Object result = JSON.toJSONString(args);
        System.out.println("调用后，结果：{}" + result);
        return result;

    }
}
