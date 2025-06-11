package java核心编程.第1_10章.内部类;

/**
 * 日期 : 2020/9/13.
 * 创建 : xin.li
 * 描述 :
 */
class OutClass {


    interface IOut{
        int value();
    }

    class BaseIOut implements IOut{
        //内部类不可用有static成员
//        private static String aaa = "";
//
//        public static void getAAA(){};
//
//        static class HHHH{}

        private int value;

        public BaseIOut(int value) {
            this.value = value;
        }

        @Override
        public int value() {
            return value;
        }
    }

    public BaseIOut wrapping(int x){
        return new BaseIOut(x * 2) {
            @Override
            public int value() {
                return super.value() * 3;
            }
        };
    }

    public IOut wrapping2(int x){
        return new IOut() {

            private int value ;

            {
                this.value = x;
            }

            @Override
            public int value() {
                return value * 4;
            }

            public void f(){

            }
        };
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        BaseIOut wrapping = outClass.wrapping(3);
        System.out.println(wrapping.value());
        IOut iOut = outClass.wrapping2(3);
        System.out.println(iOut.value());
    }
}
