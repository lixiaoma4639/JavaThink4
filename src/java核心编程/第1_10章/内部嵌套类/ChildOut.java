package java核心编程.第1_10章.内部嵌套类;

import java核心编程.第1_10章.内部嵌套类.StaticOut.BaseInner;

/**
 * 日期 : 2020/9/14.
 * 创建 : xin.li
 * 描述 : 普通类继承内部类
 */
class ChildOut extends BaseInner{

//    public ChildOut() {
//    }

    public ChildOut(StaticOut out) {
        out.super();
        System.out.println("1");
    }

    public static void main(String[] args) {
        StaticOut staticOut = new StaticOut();
        ChildOut childOut = new ChildOut(staticOut);
    }

}
