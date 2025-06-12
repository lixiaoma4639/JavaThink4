package java核心编程.第二十章注解.生成外部文件;

/**
 * 日期 : 2020/12/14.
 * 创建 : xin.li
 * 描述 :
 */
public @interface Uniqueness {
    Constrains constrains() default @Constrains(unique = true);
}
