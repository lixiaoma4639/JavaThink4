package java核心编程.第14章类型信息.空对象;

import java.util.List;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
interface Robot {
    String name();
    List<Operation> operations();

    public static void test(Robot robot){
        if (robot instanceof Null){
            System.out.println("[null robot...]");
        }
        System.out.println("name : " + robot.name());
        for (Operation o: robot.operations()) {
            System.out.println(o.description());
            o.command();
        }
    }
}
