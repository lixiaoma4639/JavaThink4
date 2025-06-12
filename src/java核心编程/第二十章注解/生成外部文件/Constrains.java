package java核心编程.第二十章注解.生成外部文件;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日期 : 2020/12/14.
 * 创建 : xin.li
 * 描述 :
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constrains {

    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;

}
