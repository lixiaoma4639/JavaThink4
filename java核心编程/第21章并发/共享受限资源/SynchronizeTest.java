package java核心编程.第21章并发.共享受限资源;


/**
 * 日期 : 2020/12/23.
 * 创建 : xin.li
 * 描述 :
 */
class SynchronizeTest  {

    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new A();
        synchronizeTest = null;
        A a = (A) synchronizeTest;


    }


    static class A extends SynchronizeTest{}
}
