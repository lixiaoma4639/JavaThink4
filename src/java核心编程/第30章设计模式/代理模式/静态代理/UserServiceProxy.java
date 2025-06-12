package java核心编程.第30章设计模式.代理模式.静态代理;

import java核心编程.第30章设计模式.代理模式.UserService;
import java核心编程.第30章设计模式.代理模式.UserServiceImpl;

// 用户服务代理
public class UserServiceProxy implements UserService {
    private UserService target; // 被代理对象

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void addUser(String name) {
        System.out.println("[代理] 开始添加用户...");
        long start = System.currentTimeMillis();

        target.addUser(name); // 调用真实对象的方法

        long end = System.currentTimeMillis();
        System.out.println("[代理] 添加用户完成，耗时: " + (end - start) + "ms");
    }

    @Override
    public void deleteUser(String name) {
        System.out.println("[代理] 开始删除用户...");
        long start = System.currentTimeMillis();

        target.deleteUser(name); // 调用真实对象的方法

        long end = System.currentTimeMillis();
        System.out.println("[代理] 删除用户完成，耗时: " + (end - start) + "ms");
    }

    public static void main(String[] args) {
        // 创建真实对象
        UserService realService = new UserServiceImpl();

        // 创建代理对象
        UserService proxy = new UserServiceProxy(realService);

        // 通过代理对象调用方法
        proxy.addUser("张三");
        proxy.deleteUser("李四");
    }
}
