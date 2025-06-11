package java核心编程.第1_10章.继承初始化顺序;

import java.util.ArrayList;

/**
 * 日期 : 2020/8/23.
 * 创建 : xin.li
 * 描述 :
 */
class ExtendsChild extends BaseExtends {

    private int k = printInit("ExtendsChild.k 初始化...");
    private static int x2 = printInit("ExtendsChild static  int  x2 初始化...");

    public ExtendsChild() {
        super();
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("child play...");
    }

    @Override
    public ArrayList<String> xieBian() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("main方法 开始了...");
        ExtendsChild child = new ExtendsChild();
        child.play();
    }
}
