package java核心编程.第20章注解.基本语法;

/**
 * 日期 : 2020/11/15.
 * 创建 : xin.li
 * 描述 :
 */
class TestTable {

    public void execute(){
        System.out.println("execute....");
    }

    @Test(id = 47)
    void testExecute(){
        execute();
    }

    public static void main(String[] args) {
        TestTable testTable = new TestTable();
        testTable.testExecute();
    }
}
