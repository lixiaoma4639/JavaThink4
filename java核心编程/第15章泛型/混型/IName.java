package java核心编程.第15章泛型.混型;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
interface IName {
    String getName();

    static class NameImpl implements IName{
        String name;

        public NameImpl() {
            name = "Lx";
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
