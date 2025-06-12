package java核心编程.第12章异常.finally处理;

/**
 * 日期 : 2020/11/18.
 * 创建 : xin.li
 * 描述 :
 */
class 异常丢失 {

    static class AException extends Exception{
        @Override
        public String toString() {
            return "A异常触发了....";
        }
    }

    static class BException extends Exception{
        @Override
        public String toString() {
            return "B异常触发了....";
        }
    }

    void f() throws AException{
        throw new AException();
    }

    void g() throws BException{
        throw new BException();
    }


    public static void main2(String[] args) {
        异常丢失 lost = new 异常丢失();
        try {
            try {
                lost.f();
            } finally {
                //这样写会丢失A异常
                lost.g();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }finally {
            //如果在这里添加return,则 throw new RuntimeException();不会抛出异常,异常丢失
            return;
        }
    }
}
