package java核心编程.第15章泛型.混型;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import java核心编程.第15章泛型.简单泛型.元组.TwoTuple;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
class MixinProxy implements InvocationHandler {
    Map<String, Object> delegateByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegateByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> tuple : pairs) {
            for (Method method : tuple.second.getMethods()) {
                String methodName = method.getName();
                if (!delegateByMethod.containsKey(methodName)) {
                    delegateByMethod.put(methodName, tuple.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        Object delegate = delegateByMethod.get(name);
        return method.invoke(delegate, args);
    }


    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < interfaces.length; i++) {
            interfaces[i] = (Class) pairs[i].second;

        }
        ClassLoader classLoader = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(classLoader, interfaces, new MixinProxy(pairs));
    }

    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                new TwoTuple(new Base.BaseImpl(), Base.class),
                new TwoTuple(new ITime.ITimeImpl(), ITime.class),
                new TwoTuple(new SerialNumber.SerialNumberImpl(), SerialNumber.class),
                new TwoTuple(new IName.NameImpl() , IName.class)
        );

        Base base = (Base) mixin;
        ITime iTime = (ITime) mixin;
        SerialNumber serialNumber = (SerialNumber) mixin;
        IName iName = (IName) mixin;

        base.setVal("哈哈");
        System.out.println(base.getVal());
        System.out.println(iTime.getTime());
        System.out.println(serialNumber.getSerialNumber());
        System.out.println(iName.getName());

    }
}
