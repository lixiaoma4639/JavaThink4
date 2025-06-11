package java核心编程.第12章异常.捕获所有的异常;

/**
 * 日期 : 2020/11/16.
 * 创建 : xin.li
 * 描述 :
 */
class 捕获所有异常 {

    public static void main(String[] args) {
        try {
            throw new Exception("hhhh....");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.toString());
            e.printStackTrace(System.out);
        }
    }
}
