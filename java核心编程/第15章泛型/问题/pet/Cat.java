package java核心编程.第15章泛型.问题.pet;

/**
 * 日期 : 2020/12/9.
 * 创建 : xin.li
 * 描述 :
 */
//error
//class Cat extends ComparablePet implements Comparable<Cat> {
class Cat extends ComparablePet implements Comparable<ComparablePet>{
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
