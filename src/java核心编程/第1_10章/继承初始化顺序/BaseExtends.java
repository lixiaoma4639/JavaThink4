package java核心编程.第1_10章.继承初始化顺序;

import java.util.List;

/**
 * 日期 : 2020/8/23.
 * 创建 : xin.li
 * 描述 :
 */
abstract class BaseExtends {
    private int i = 9;
    protected int j ;
    private static int x1 = printInit("BaseExtends static int x1 初始了...");

    public BaseExtends() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    static int printInit(String string){
        System.out.println(string);
        return 47;
    }

    public void play(){
        System.out.println("Base play...");
    }

    public abstract List<String> xieBian();
}
