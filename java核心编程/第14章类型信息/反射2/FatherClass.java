package java核心编程.第14章类型信息.反射2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
public class FatherClass {
    public String mFatherName;
    public int mFatherAge;

    public void printFatherMsg() {
    }

    public static void main2(String[] args) {
//        printMethods();

//        try {
//            getPrivateMethod();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            modifyPrivateFiled();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Class<A> integerClass = A.class;
//        try {
//            Method method = integerClass.getDeclaredMethod("f");
//            //getDeclaringClass 表示方法声明在哪个类里
//            Class<?> declaringClass = method.getDeclaringClass();
//            System.out.println(declaringClass.getSimpleName());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

    }

    class A {
        void f(){}
    }


    /**
     * 修改对象私有变量的值
     * 为简洁代码，在方法上抛出总的异常
     */
    private static void modifyPrivateFiled() throws Exception {
        //1. 获取 Class 类实例
        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        //2. 获取私有变量
        Field privateField = mClass.getDeclaredField("MSG");

        //3. 操作私有变量
        if (privateField != null) {
            //获取私有变量的访问权
            privateField.setAccessible(true);

            //修改私有变量，并输出以测试
            System.out.println("Before Modify：MSG = " + testClass.getMsg());

            //调用 set(object , value) 修改变量的值
            //privateField 是获取到的私有变量
            //testClass 要操作的对象
            //"Modified" 为要修改成的值 , 类型需要和私有变量类型一致
            privateField.set(testClass, "Modified");
            System.out.println("After Modify：MSG = " + testClass.getMsg());
        }
    }


    public static class TestClass {

        private String MSG = "Original";

        private void privateMethod(String head , int tail){
            System.out.print(head + tail);
        }

        public String getMsg(){
            return MSG;
        }
    }


    /**
     * 访问对象的私有方法
     * 为简洁代码，在方法上抛出总的异常，实际开发别这样
     */
    private static void getPrivateMethod() throws Exception{
        //1. 获取 Class 类实例
        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        //2. 获取私有方法
        //第一个参数为要获取的私有方法的名称
        //第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
        //方法参数也可这么写 ：new Class[]{String.class , int.class}
        Method privateMethod =
                mClass.getDeclaredMethod("privateMethod", String.class, int.class);

        //3. 开始操作方法
        if (privateMethod != null) {
            //获取私有方法的访问权
            //只是获取访问权，并不是修改实际权限
            privateMethod.setAccessible(true);

            //使用 invoke 反射调用私有方法
            //privateMethod 是获取到的私有方法
            //testClass 要操作的对象
            //后面两个参数传实参
            privateMethod.invoke(mClass.newInstance(), "Java Reflect ", 666);
        }
    }


    /**
     * 通过反射获取类的所有变量
     */
    private static void printFields(){
        //1.获取并输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类的名称：" + mClass.getName());

        //2.1 获取所有 public 访问权限的变量
        // 包括本类声明的和从父类继承的
        Field[] fields = mClass.getFields();

        //2.2 获取所有本类声明的变量（不问访问权限）
        //Field[] fields = mClass.getDeclaredFields();

        //3. 遍历变量并输出变量信息
        for (Field field :
                fields) {
            //获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //输出变量的类型及变量名
            System.out.println(field.getType().getName()
                    + " " + field.getName());
        }
    }


    /**
     * 通过反射获取类的所有方法
     */
    private static void printMethods(){
        //1.获取并输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类的名称：" + mClass.getName());

        //2.1 获取所有 public 访问权限的方法
        //包括自己声明和从父类继承的
        Method[] mMethods = mClass.getMethods();

        //2.2 获取所有本类的的方法（不问访问权限）
        //Method[] mMethods = mClass.getDeclaredMethods();

        //3.遍历所有方法
        for (Method method :
                mMethods) {
            //获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " "
                    + method.getName() + "( ");
            //获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter:
                    parameters) {
                System.out.print(parameter.getType().getName()
                        + " " + parameter.getName() + ",");
            }
            //获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0){
                System.out.println(" )");
            }
            else {
                for (Class c : exceptionTypes) {
                    System.out.println(" ) throws "
                            + c.getName());
                }
            }
        }
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class mClass = SonClass.class;
        Method logEvents = mClass.getMethod("getCountry", String.class);

        System.out.println(logEvents.getReturnType());
        System.out.println(logEvents.getReturnType() == String.class);
        String country = (String) logEvents.invoke(null, "中国");
        System.out.println(country);
    }

    public static class SonClass extends FatherClass {

        private String mSonName;
        protected int mSonAge;
        public String mSonBirthday;

        public void printSonMsg() {
            System.out.println("Son Msg - name : "
                    + mSonName + "; age : " + mSonAge);
        }

        private void setSonName(String name) {
            mSonName = name;
        }

        private void setSonAge(int age) {
            mSonAge = age;
        }

        private int getSonAge() {
            return mSonAge;
        }

        private String getSonName() {
            return mSonName;
        }

        public static String getCountry(String country) {
            return country + "在亚洲...";
        }
    }

}
