package java核心编程.第14章类型信息.接口与类型信息.包B;

import java.lang.reflect.Method;

import java核心编程.第14章类型信息.接口与类型信息.包A.A;
import java核心编程.第14章类型信息.接口与类型信息.包A.HideC;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class HideCImpl {
    public static void main(String[] args) throws Exception {
        A a = HideC.makeA();
        a.f();
        System.out.println(a.getClass().getSimpleName());

//        if (a instanceof C){
//
//        }

        callHideMethod(a , "g");
        callHideMethod(a , "u");
        callHideMethod(a , "v");
        callHideMethod(a , "w");
    }

    private static void callHideMethod(Object a , String methodStr) throws Exception{
        Method declaredMethod = a.getClass().getDeclaredMethod(methodStr);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(a);
    }
}
