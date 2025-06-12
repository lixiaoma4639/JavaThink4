package java核心编程.第二十章注解.定义注解;

/**
 * 日期 : 2020/12/14.
 * 创建 : xin.li
 * 描述 :
 */
public class PasswordUtils {
    @UseCase(id = 47 , description = "密码校验")
    public boolean validate(){
        return true;
    }

    @UseCase(id = 48)
    public String encrypt(){
        return "xin mi ma";
    }

    @UseCase(id = 49 , description = "检查新密码")
    public boolean check(){
        return true;
    }
}
