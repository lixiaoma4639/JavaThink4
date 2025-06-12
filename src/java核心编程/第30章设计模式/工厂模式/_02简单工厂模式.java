package java核心编程.第30章设计模式.工厂模式;

public class _02简单工厂模式 {


    // 1. 定义产品接口
    interface Shape {
        void draw();
    }

    // 2. 实现具体产品
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("画一个圆形");
        }
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("画一个矩形");
        }
    }

    // 3. 创建简单工厂
    static class ShapeFactory {
        // 使用静态方法创建实例
        public static Shape createShape(String type) {
            if ("circle".equalsIgnoreCase(type)) {
                return new Circle();
            } else if ("rectangle".equalsIgnoreCase(type)) {
                return new Rectangle();
            }
            throw new IllegalArgumentException("未知形状类型: " + type);
        }
    }

    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        circle.draw(); // 输出: 画一个圆形

        Shape rectangle = ShapeFactory.createShape("rectangle");
        rectangle.draw(); // 输出: 画一个矩形
    }
}
