package java核心编程.第14章类型信息.反射;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
class 动态代理 {

    interface AInterface{
        void doSomething();
        void somethingElse(String arg);
    }

    static class RealObject implements AInterface{

        @Override
        public void doSomething() {
            System.out.println("do something ..");
        }

        @Override
        public void somethingElse(String arg) {
            System.out.println("do something else " + arg);
        }
    }

    /**
     * 代理类
     */
    static class SimpleProxy implements AInterface{

        private AInterface proxy;

        public SimpleProxy(AInterface proxy) {
            this.proxy = proxy;
        }

        @Override
        public void doSomething() {
            System.out.println("SimpleProxy do something ..");
            proxy.doSomething();
        }

        @Override
        public void somethingElse(String arg) {
            System.out.println("SimpleProxy do something else " + arg);
            proxy.somethingElse(arg);
        }
    }

    static class SimpleProxyDemo{
        private static void action(AInterface aInterface){
            aInterface.doSomething();
            aInterface.somethingElse("其他");
        }

        public static void main(String[] args) {
//            action(new RealObject());
            action(new SimpleProxy(new RealObject()));
        }
    }
}
