package java核心编程.第1_10章.内部类.内部类继承;

/**
 * 日期 : 2020/9/14.
 * 创建 : xin.li
 * 描述 :
 */
class Egg2 {
    private Yolk yolk = new Yolk();

    protected class Yolk{
        public Yolk() {
            System.out.println("Egg2.Yolk()...");
        }
        public void f(){
            System.out.println("Egg2.Yolk.f()...");
        }
    }
}
