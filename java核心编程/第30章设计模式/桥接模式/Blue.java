package java核心编程.第30章设计模式.桥接模式;


public class Blue implements Color {
    @Override
    public void applyColor() {
        System.out.print("蓝色的");
    }
}