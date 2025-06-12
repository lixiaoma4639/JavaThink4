package java核心编程.第14章类型信息.接口与类型信息.包A;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class C implements A {
    @Override
    public void f() {
        System.out.println("f...");
    }

    public void g(){
        System.out.println("g...");
    }

    void u(){
        System.out.println("u...");
    }

    protected void v(){
        System.out.println("v...");
    }

    private void w(){
        System.out.println("w...");
    }
}
