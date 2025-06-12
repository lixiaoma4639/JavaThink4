package java核心编程.第12章异常.异常的限制;

/**
 * 日期 : 2020/11/18.
 * 创建 : xin.li
 * 描述 :
 */
class LimitException {

    static class BaseAException extends Exception{}
    static class A1Exception extends Exception{}
    static class A2Exception extends Exception{}

    static abstract class Inning{
        public Inning() throws BaseAException{
        }

        public void event() throws BaseAException{}

        public abstract void at() throws A1Exception , A2Exception;

        public void work(){}
    }

    static class BaseBException extends Exception{}
    static class B1Exception extends Exception{}

    static class A22Exception extends A2Exception{}

    interface Storm{
        void event() throws B1Exception;
        void b2Rain()throws A22Exception;
    }

    static class StormInning extends Inning implements Storm{

        public StormInning() throws B1Exception , BaseAException{
            //构造的异常不能在子类构造中被捕获
            super();
        }

        public StormInning(String s) throws A22Exception , BaseAException{
        }

        @Override
        public void event() {
            try {
                super.event();
            } catch (BaseAException e) {
                e.printStackTrace();
            }
        }

        //        @Override
//        public void event() throws B1Exception , BaseAException{
//        }

        @Override
        public void at() throws  A22Exception{
        }

        @Override
        public void work(){
        }

        @Override
        public void b2Rain() throws A22Exception {

        }
    }

    public static void main(String[] args) {
        Inning  stormInning = null;
        try {
            stormInning = new StormInning();
        } catch (B1Exception e) {
            e.printStackTrace();
        } catch (BaseAException e) {
            e.printStackTrace();
        }

        try {
            stormInning.at();
        } catch (A1Exception e) {
            e.printStackTrace();
        } catch (A2Exception e) {
            e.printStackTrace();
        }


        if (stormInning != null){
            try {
                stormInning.event();
            } catch (BaseAException e) {
                e.printStackTrace();
            }
        }
    }
}
