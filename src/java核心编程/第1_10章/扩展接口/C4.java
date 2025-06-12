package java核心编程.第1_10章.扩展接口;

/**
 * 日期 : 2020/9/9.
 * 创建 : xin.li
 * 描述 :
 */
class C4 extends C implements I3 {

    @Override
    public int f() {
        super.f();
        System.out.println("我是c4...");
        return 2;
    }

    public static void main(String[] args) {
        C5 c5 = new C5();
        C5.CC1Child cc1 = (C5.CC1Child) c5.get();
    }
}
