package java核心编程.static_learn;

/**
 * 日期 : 2020/8/22.
 * 创建 : xin.li
 * 描述 :
 */
class Table {
    static Bowl bowl1 = new Bowl(1);
    static Bowl bowl2 = new Bowl(2);

    void f2(int marker){
        System.out.println("marker = " + marker);
    }
}
