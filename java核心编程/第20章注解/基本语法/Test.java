package java核心编程.第20章注解.基本语法;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日期 : 2020/11/15.
 * 创建 : xin.li
 * 描述 :
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    public int id();
    public String description() default "no description";
}
