package java核心编程.第15章泛型.擦除的补偿.创建类型实例;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class Widget {
    public static class MyFactory implements IFactory<Widget>{
        @Override
        public Widget create() {
            return new Widget();
        }
    }

    @Override
    public String toString() {
        return "widget";
    }
}
