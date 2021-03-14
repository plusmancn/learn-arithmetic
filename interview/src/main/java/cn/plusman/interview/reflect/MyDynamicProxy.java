package cn.plusman.interview.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * cn.plusman.interview.reflect
 *
 * @author plusman
 * @since 12/15/20
 */
public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl helloImpl = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(helloImpl);

        Hello proxyHello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[] {Hello.class}, handler);

        // proxyHello.sayHello();
        proxyHello.sayHello("plusman");
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

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking sayHello");
        Object result = method.invoke(targetCC, args);
        return result;
    }
}