package java核心编程.第1_10章.扩展接口;

/**
 * 日期 : 2020/9/9.
 * 创建 : xin.li
 * 描述 :
 */
//class C5 extends C implements I1 {
//}
class C5{

    private CC1 cc1;

    private interface CC1{
        void f();
    }

    public class CC1Child implements CC1{

        @Override
        public void f() {
            System.out.println("jin////");
        }
    }

    public CC1 get(){
        return new CC1Child();
    }

}
