package java核心编程.第12章异常.捕获所有的异常;

/**
 * 日期 : 2020/11/16.
 * 创建 : xin.li
 * 描述 :
 */
class 栈轨迹 {

    static void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            //获取栈轨迹
            StackTraceElement[] stackTraces = e.getStackTrace();
            for (StackTraceElement element: stackTraces) {
                System.out.println(element);
            }
        }
    }

    static void g(){
        f();
    }

    static void h(){
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("--------------------");
        g();
        System.out.println("--------------------");
        h();
    }
}
