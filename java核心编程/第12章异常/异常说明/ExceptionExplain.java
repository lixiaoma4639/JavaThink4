package java核心编程.第12章异常.异常说明;

/**
 * 日期 : 2020/11/16.
 * 创建 : xin.li
 * 描述 :
 */
class ExceptionExplain {

    private void explain() throws NullPointerException , IllegalArgumentException , MyException{
        System.out.println("explain....");
    }
    private static void explain2() throws MyException{
        System.out.println("explain2....");
        throw new MyException();
    }

    public static void main(String[] args) {
        ExceptionExplain exceptionExplain = new ExceptionExplain();
        try {
            exceptionExplain.explain();
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            explain2();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    private static class MyException extends Exception{
        public MyException() {
        }

        public MyException(String message) {
            super(message);
        }
    }
}
