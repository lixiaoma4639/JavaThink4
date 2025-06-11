package java核心编程.第二十章注解.apt注解处理器;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日期 : 2020/12/15.
 * 创建 : xin.li
 * 描述 :
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractPolicy {
    public String value();
}
