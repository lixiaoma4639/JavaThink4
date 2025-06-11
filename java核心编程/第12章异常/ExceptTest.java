package java核心编程.第12章异常;

/**
 * 日期 : 2020/11/15.
 * 创建 : xin.li
 * 描述 :
 */
class ExceptTest {
    public static void main(String[] args) {

        String a = (String)null;
        System.out.println(a);
        try {
            a.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("抓住异常了");
    }
}
