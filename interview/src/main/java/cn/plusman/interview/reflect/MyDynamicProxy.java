package cn.plusman.interview.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 参考文档：https://www.baeldung.com/java-dynamic-proxies
 * cn.plusman.interview.reflect
 * @author plusman
 * @since 12/15/20
 */
public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl helloImpl = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler();
        // 第二个参数必须呀是 interface 类型，不然无法校验通过
        // 此处 HelloImpl.class 是 class 类型
        Hello proxyHello = (HelloImpl) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, handler);
        // proxyHello.sayHello();
        // proxyHello.sayHello("plusman");
        
        HelloIndependent hi = new HelloIndependent();
        
        hi.pong();
    }
}

interface Hello {
    void sayHello();
    
    /**
     * overload test
     * @param name
     */
    void sayHello(String name);
}

/**
 * 无任何接口抽象
 */
class HelloIndependent {
    public void pong() {
        System.out.println("Hello pong");
    }
}

class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object targetCC;

    public MyInvocationHandler(Object target) {
        this.targetCC = target;
    }
    
    public MyInvocationHandler() {
    }
    
    /**
     * proxy != handler
     * proxy 是通过字节码生成的接口实例化对象
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " was invoked");
        return null;
    }
}