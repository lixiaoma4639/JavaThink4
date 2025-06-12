package java核心编程.第1_10章.内部类;

/**
 * 日期 : 2020/9/12.
 * 创建 : xin.li
 * 描述 : 内部类对象创建
 */
class AAAA {

    public IPublic get(){
        class CCC implements IPublic{

        }
        return new CCC();
    }

    class BBB{

    }

    public static void main(String[] args) {
        AAAA aaaa = new AAAA();
        BBB bbb = aaaa.new BBB();
        IPublic iPublic = aaaa.get();
    }
}
