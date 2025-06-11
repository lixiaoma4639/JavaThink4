package java核心编程.第1_10章.枚举;

/**
 * 日期 : 2020/8/22.
 * 创建 : xin.li
 * 描述 :
 */
class EnumTest {
    public static void main(String[] args) {
        for (Game item: Game.values()) {
            System.out.println(item.name() + " , ordinal: " + item.ordinal());
        }
    }
}
