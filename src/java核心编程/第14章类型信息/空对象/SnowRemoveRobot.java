package java核心编程.第14章类型信息.空对象;

import java.util.Arrays;
import java.util.List;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class SnowRemoveRobot implements Robot{
    String name;

    public SnowRemoveRobot(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Robot.test(new SnowRemoveRobot("波士顿动力机器人"));
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + " 可以扫雪...";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + "开始扫雪...");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + " 制作冰淇淋...";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + "开始制作冰淇淋...");
                    }
                }
        );
    }
}
