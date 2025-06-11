package java核心编程.第1_10章.数组;

/**
 * 日期 : 2020/8/22.
 * 创建 : xin.li
 * 描述 :
 */
class ArrayTest {

    public static void main(String[] args) {
//        print(new Object[]{new Integer(44) , new Float(12.3) , new Double(33.3333)});
        print2(1 , 2 , "我是李鑫" , new Integer(44));
        print2((Object[]) new Integer[]{1 , 2 , 3 ,4 });
        System.out.println(new int[0].getClass());
    }



    static void print2(Object... objects){
        for (Object object: objects) {
            System.out.println(object+ " ");
        }
    }

    static void print(Object[] objects){
        for (Object object: objects) {
            System.out.println(object+ " ");
        }
    }

    static void print(Integer... objects){
        for (Object object: objects) {
            System.out.println(object+ " ");
        }
    }

    static void print(Float... objects){
        for (Object object: objects) {
            System.out.println(object+ " ");
        }
    }
}
