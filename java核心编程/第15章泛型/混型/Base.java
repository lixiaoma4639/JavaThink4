package java核心编程.第15章泛型.混型;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
interface Base {
    public String getVal() ;

    public void setVal(String val) ;

    static class BaseImpl implements Base{
        String val;

        @Override
        public String getVal() {
            return val;
        }

        @Override
        public void setVal(String val) {
            this.val = val;
        }
    }
}
