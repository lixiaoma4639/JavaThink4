package java核心编程.第30章设计模式.代理模式.动态代理;

import java核心编程.第30章设计模式.代理模式.UserService;
import java核心编程.第30章设计模式.代理模式.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceInvocationHandler implements InvocationHandler {
    private Object target; // 被代理对象

    public UserServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[动态代理] 开始执行 " + method.getName() + " 操作...");
        long start = System.currentTimeMillis();

        // 调用真实对象的方法
        Object result = method.invoke(target, args);

        long end = System.currentTimeMillis();
        System.out.println("[动态代理] " + method.getName() + " 操作完成，耗时: " + (end - start) + "ms");
        return result;
    }

    public static void main(String[] args) {
        // 创建真实对象
        UserService realService = new UserServiceImpl();

        // 创建调用处理器
        UserServiceInvocationHandler handler = new UserServiceInvocationHandler(realService);

        // 创建动态代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(), // 类加载器
                new Class[]{UserService.class},    // 代理接口
                handler                            // 调用处理器
        );

        // 通过代理对象调用方法
        proxy.addUser("王五");
        proxy.deleteUser("赵六");
    }
}
