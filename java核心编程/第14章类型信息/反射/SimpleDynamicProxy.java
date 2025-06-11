package java核心编程.第14章类型信息.反射;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
class SimpleDynamicProxy {

    public static void consumer(Interface aInterface){
        aInterface.doSomething();
        aInterface.somethingElse("hello...");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
//            consumer(realObject);

        Interface proxyInstance = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                //被代理的对象的父接口列表
//                RealObject.class.getInterfaces(),
                new Class[]{Interface.class},
                //自定义的调用处理器, 动态代理可以将所有调用重定向到 调用代理器中
                new DynamicProxyHandler(realObject));

        consumer(proxyInstance);
    }



    static class DynamicProxyHandler implements InvocationHandler {
        /**
         * 被代理的实际对象 的引用
         */
        private Object proxied;

        public DynamicProxyHandler(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理对象是 : " + proxy.getClass() + "\nmethod是 : " + method + "\n参数args : " + args);
            if (args != null){
                for (Object obj :args) {
                    System.out.println(obj);
                }
            }
            return method.invoke(proxied , args);
        }
    }


    interface Interface{
        void doSomething();
        void somethingElse(String arg);
    }

    static class RealObject implements Interface{

        @Override
        public void doSomething() {
            System.out.println("do something ..");
        }

        @Override
        public void somethingElse(String arg) {
            System.out.println("do something else " + arg);
        }
    }
}
