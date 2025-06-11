package java核心编程.第二十章注解.生成外部文件;

/**
 * 日期 : 2020/12/14.
 * 创建 : xin.li
 * 描述 :
 */
@DBTable(name = "MEMBER")
class MemberBean {

    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30 , constrains = @Constrains(primaryKey = true))
    String handler;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandler() {
        return handler;
    }

    public static int getMemberCount() {
        return memberCount;
    }
}
