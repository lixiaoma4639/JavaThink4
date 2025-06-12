package lesson1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lixin on 2020/4/17.
 * 动态代理
 */
class ProxyTest {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        // 获取被代理类的所有接口
        Class<?>[] interfaces = HelloImpl.class.getInterfaces();
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), interfaces, handler);
        System.out.println("proxyHello: " + proxyHello);
        // 调用代理方法
        proxyHello.sayHello();


    }



    interface Hello {
        void sayHello();
    }

    static class HelloImpl implements Hello {
        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }
    }

    static class MyInvocationHandler implements InvocationHandler {
        private Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("Invoking sayHello");
            if (target == null){
                return null;
            }
            if (method.getName().equalsIgnoreCase("sayHellwo")) {
                System.out.println("代理前。。。");
                Object result = method.invoke(target, args);
                System.out.println("代理后。。。");
                return result;
            }
            return  method.invoke(target, args);
        }
    }
}
