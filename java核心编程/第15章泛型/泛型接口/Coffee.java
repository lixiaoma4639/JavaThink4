package java核心编程.第15章泛型.泛型接口;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
public class Coffee {
    private static long count = 0;
    private final long Id = count++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " +Id;
    }

    static class ACoffee extends Coffee{}
    static class BCoffee extends Coffee{}
    static class CCoffee extends Coffee{}
    static class DCoffee extends Coffee{}
    static class ECoffee extends Coffee{}
}
