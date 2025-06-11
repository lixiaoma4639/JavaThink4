package java核心编程.第15章泛型.协变逆变;

import java.util.Arrays;
import java.util.List;

import java核心编程.第15章泛型.通配符.CovariantArray;

/**
 * 日期 : 2020/12/6.
 * 创建 : xin.li
 * 描述 :
 */
class GenericReading {
    static <T> T readingExact(List<T> data){
        return data.get(0);
    }

    static List<CovariantArray.A> a1s = Arrays.asList(new CovariantArray.A());
    static List<CovariantArray.A2> a2s = Arrays.asList(new CovariantArray.A2());

    static void f1(){
        CovariantArray.A2 a2 = readingExact(a2s);
        CovariantArray.A a = readingExact(a1s);
        a = readingExact(a2s);
    }

    static class Reader<T>{
        T read(List<T> list){
            return list.get(0);
        }
    }

    static void f2(){
        Reader<CovariantArray.A> aReader = new Reader<>();
        CovariantArray.A read = aReader.read(a1s);
        //error
//        aReader.read(a2s)

    }

    static void f3(){
        CovReader<CovariantArray.A> covReader = new CovReader<>();
        CovariantArray.A read = covReader.read(a1s);
        CovariantArray.A read1 = covReader.read(a2s);
    }

    static class CovReader<T>{
        T read(List<? extends  T> list){
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }

}
