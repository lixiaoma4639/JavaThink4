package java核心编程.第30章设计模式.桥接模式;

// 形状抽象类 - Abstraction
public abstract class Shape {
    protected Color color;  // 桥接的关键：持有颜色对象的引用

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();


    // 具体形状实现 - RefinedAbstraction
    public static class Circle extends Shape {
        public Circle(Color color) {
            super(color);
        }

        @Override
        public void draw() {
            color.applyColor();
            System.out.println("圆形");
        }
    }

    public static class Square extends Shape {
        public Square(Color color) {
            super(color);
        }

        @Override
        public void draw() {
            color.applyColor();
            System.out.println("正方形");
        }
    }

    // 新增三角形形状（不涉及颜色修改）
    public static class Triangle extends Shape {
        public Triangle(Color color) {
            super(color);
        }

        @Override
        public void draw() {
            color.applyColor();
            System.out.println("的三角形");
        }
    }

    public static void main(String[] args) {
        // 创建不同颜色
        Color red = new Red();
        Color blue = new Blue();

        // 红色圆形
        Shape redCircle = new Circle(red);
        redCircle.draw();

        // 蓝色圆形
        Shape blueCircle = new Circle(blue);
        blueCircle.draw();

        // 红色正方形
        Shape redSquare = new Square(red);
        redSquare.draw();

        // 蓝色正方形
        Shape blueSquare = new Square(blue);
        blueSquare.draw();

        // 新增绿色三角形
        Shape greenTriangle = new Triangle(new Green());
        greenTriangle.draw();
    }
}


