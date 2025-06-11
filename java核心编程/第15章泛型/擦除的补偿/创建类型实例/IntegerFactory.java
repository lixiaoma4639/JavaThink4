package java核心编程.第15章泛型.擦除的补偿.创建类型实例;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class IntegerFactory implements IFactory<Integer>{
    @Override
    public Integer create() {
        return 0;
    }
}
