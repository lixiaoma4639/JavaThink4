package java核心编程.第30章设计模式.原型模式;

public class Test {
    // 1. 定义原型接口
    public interface Graphic extends Cloneable {
        void draw();
        Graphic clone();
    }

    // 2. 实现具体原型
    public static class Rectangle implements Graphic {
        private int width;
        private int height;
        private String color;

        public Rectangle(int width, int height, String color) {
            this.width = width;
            this.height = height;
            this.color = color;
            // 模拟创建成本高的操作
            System.out.println("创建一个新的Rectangle对象，成本较高...");
        }

        @Override
        public void draw() {
            System.out.printf("绘制一个%s的矩形，宽%d，高%d\n", color, width, height);
        }

        @Override
        public Rectangle clone() {
            try {
                return (Rectangle) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        // 可以添加修改属性的方法
        public void setColor(String color) {
            this.color = color;
        }
    }

    // 3. 客户端使用
    public static void main(String[] args) {
        // 创建原型对象
        Rectangle original = new Rectangle(100, 50, "红色");
        original.draw();

        // 通过克隆创建新对象
        Rectangle clone1 = original.clone();
        clone1.setColor("蓝色");
        clone1.draw();

        Rectangle clone2 = original.clone();
        clone2.setColor("绿色");
        clone2.draw();

        System.out.println("original == clone1? " + (original == clone1));
        System.out.println("original.getClass() == clone1.getClass()? " +
                (original.getClass() == clone1.getClass()));
    }
}
