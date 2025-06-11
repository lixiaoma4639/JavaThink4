package java核心编程.第14章类型信息.Class对象;

/**
 * 日期 : 2020/11/30.
 * 创建 : xin.li
 * 描述 :
 */
class ClassLearn {
    static class A{
        static {
            System.out.println("hello , A...");
        }
    }
    static class B{
        static {
            System.out.println("hello , B...");
        }
    }
    static class C{
        static {
            System.out.println("hello , C...");
        }
    }

    public static void main(String[] args) {
        System.out.println("hello , main...");
        new A();
        System.out.println("after create A()...");

        try {
            Class<?> aClass = Class.forName("java核心编程.第14章类型信息.Class对象.ClassB");

            //虚拟构造器, 必须要有默认无参构造器
            ClassB  classB = (ClassB) aClass.newInstance();
            classB.printTest();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到B...");
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println("after look B...");

        new C();

        System.out.println("after create C()...");
    }


}
