package java核心编程.第14章类型信息.空对象;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
class Person {

    public final String first;
    public final String last;
    public final String address;

    public static final Person mNull = new NullPerson();

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    private static class NullPerson extends Person implements Null{

        private NullPerson() {
            super("none", "none", "none");
        }
    }

}
