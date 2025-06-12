package java核心编程.第二十章注解.定义注解.注解处理器;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java核心编程.第二十章注解.定义注解.PasswordUtils;
import java核心编程.第二十章注解.定义注解.UseCase;

/**
 * 日期 : 2020/12/14.
 * 创建 : xin.li
 * 描述 :
 */
class UseCaseTracker {

    public UseCaseTracker() {
    }

    public static void trackUseCase(List<Integer> useCases , Class<?> cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null){
                System.out.println("id = " + uc.id() + " , desc = " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        for (int i = 0; i < useCases.size(); i++) {
            System.out.println("未找到UseCase id = " + useCases.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list , 47 , 48 , 49 , 50 ,51);
        trackUseCase(list , PasswordUtils.class);


        
    }
}
