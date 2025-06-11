package java核心编程.第14章类型信息.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
public class ShowMethods {
    private static String usage =
                    "A \n" +
                    "B \n" +
                    "C \n" +
                    "D \n" +
                    "E \n"
            ;
    private static Pattern pattern = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.lang.String");
            Method[] methods = c.getMethods();
            for (Method method: methods) {
                System.out.println(method.toString());
            }


            Constructor<?>[] constructors = c.getConstructors();

            for (Constructor constructor :constructors
                 ) {
//                System.out.println(constructor.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

















}
