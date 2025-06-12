package java核心编程.第30章设计模式.代理模式;

// 实际用户服务实现
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String name) {
        System.out.println("添加用户: " + name);
        // 实际业务逻辑...
    }

    @Override
    public void deleteUser(String name) {
        System.out.println("删除用户: " + name);
        // 实际业务逻辑...
    }
}
