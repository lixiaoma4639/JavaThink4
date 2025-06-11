package java核心编程.第14章类型信息.Class对象;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/1.
 * 创建 : xin.li
 * 描述 :
 */
class 泛化的class对象 {

    public static void main1(String[] args) {
        Class<Integer> integerClass = int.class;
        Class<Integer> integerClass1 = Integer.class;

        Class<?> everyClass = double.class;
        everyClass = double.class;

        //Class<Number>表示只能是Number类的class对象
        Class<Number> integerClass2 = Number.class;
        //Class<? extends Number>表示只能是Number类或Number的子类 的class对象
        Class<? extends Number> integerClass3 = int.class;
        integerClass3 = double.class;
        integerClass3 = Number.class;
    }



    static class CountedInteger{
        private static int counted;
        private final long id = counted++;

        @Override
        public String toString() {
            return Long.toString(id);
        }
    }
    static class FilledList<T>{
        private Class<T> type;

        public FilledList(Class<T> type) {
            this.type = type;
        }

        public List<T> create(int element){
            List<T> list = new ArrayList<>();
            try {
                for (int i = 0; i < element; i++) {
                    list.add(type.newInstance());
                }
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            return list;
        }

        public static void main(String[] args) {
            FilledList<CountedInteger> filledList = new FilledList<>(CountedInteger.class);
            System.out.print(filledList.create(15));

            System.out.println();

        }
    }



    static class AClass extends BClass{}
    static class BClass{}

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<AClass> aClassClass = AClass.class;
        AClass aClass = aClassClass.newInstance();
        Class<? super AClass> superclass = aClassClass.getSuperclass();
        Object object = superclass.newInstance();
        //error
//        Class<BClass> superclass2 = aClassClass.getSuperclass();

    }

}
