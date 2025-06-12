package java核心编程.第15章泛型.潜在类型机制补偿;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
class LatentReflection {

    static class Mime{
        public void a(){}
        public void b(){}
        public void sit(){
            System.out.println("我不想坐...");
        }

        @Override
        public String toString() {
            return "meme...";
        }
    }
    static class SmartDog{
        public void speak(){
            System.out.println("woof...");
        }
        public void sit(){
            System.out.println("sitting...");
        }

        public void f(){}

        @Override
        public String toString() {
            return "SmartDog...";
        }
    }

    static class Robot{
        public void speak(){
            System.out.println("瓦力...");
        }
        public void sit(){
            System.out.println("咯吱...");
        }
    }

    static class CommunicationReflect{
        public static void perform(Object speak){
            Class<?> aClass = speak.getClass();
            try {
                Method speakMethod = aClass.getMethod("speak");
                speakMethod.invoke(speak);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            try {
                Method sit = aClass.getMethod("sit");
                sit.invoke(speak);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CommunicationReflect.perform(new SmartDog());
        CommunicationReflect.perform(new Mime());
        CommunicationReflect.perform(new Robot());
    }

}
