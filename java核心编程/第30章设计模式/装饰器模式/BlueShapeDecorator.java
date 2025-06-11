package java核心编程.第30章设计模式.装饰器模式;

public class BlueShapeDecorator extends ShapeDecorator{

    public BlueShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
        setBackground(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("画边界颜色: blue");
    }

    private void setBackground(Shape decoratedShape){
        System.out.println("画背景: blue");
    }
}
