package java核心编程.第15章泛型.构建复杂模型;

import java.util.ArrayList;

import java核心编程.第15章泛型.简单泛型.元组.FourTuple;
import java核心编程.第15章泛型.简单泛型.元组.TupleTest;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class TupleList<A, B ,C , D> extends ArrayList<FourTuple<A, B ,C , D>> {
    public static void main(String[] args) {
        TupleList<Integer , Integer , Boolean , Double> tupleList = new TupleList<>();
        tupleList.add(TupleTest.h());
        tupleList.add(TupleTest.h());

        for (FourTuple<Integer , Integer , Boolean , Double> fourTuple : tupleList) {
            System.out.println(fourTuple);
        }
    }

}
