package java核心编程.第14章类型信息.空对象;

import java.lang.reflect.Proxy;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                type.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Robot[] robots = {
                new SnowRemoveRobot("长安动力"),
                newNullRobot(SnowRemoveRobot.class)
        };

        for (Robot robot : robots) {
//            if (robot instanceof Null){
//                robot = new SnowRemoveRobot("渭南动力");
//            }
            Robot.test(robot);
        }


    }
}
