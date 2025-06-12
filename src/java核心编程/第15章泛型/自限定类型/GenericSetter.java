package java核心编程.第15章泛型.自限定类型;

/**
 * 日期 : 2020/12/11.
 * 创建 : xin.li
 * 描述 :
 */
class GenericSetter<T extends GenericSetter<T>> {

    static class Base{}
    static class Driver extends Base{}

    void set(T element){
        System.out.println(element.getClass().getName());
    }

    static class DeriveGS extends GenericSetter<DeriveGS>{
        void set(Driver driver){
            System.out.println(driver.getClass().getName());
        }
    }

    public static void main(String[] args) {
        Base base = new Base();
        Driver driver = new Driver();
        DeriveGS gs = new DeriveGS();
        DeriveGS gs2 = new DeriveGS();
        GenericSetter tGenericSetter = new GenericSetter<>();

        gs.set(gs2);
//        gs.set(tGenericSetter);
        gs.set(driver);
    }
}
