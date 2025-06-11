package java核心编程.第14章类型信息.Class对象;

/**
 * 日期 : 2020/11/30.
 * 创建 : xin.li
 * 描述 :
 */
class ClassB {

    private int age;

    public ClassB() {
    }

    public ClassB(int age) {
        this.age = age;
    }

    static {
        System.out.println("hello , ClassB...");
    }

    public void printTest(){
        System.out.println("class b print....");
    }
}
