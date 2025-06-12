package java核心编程.第30章设计模式.装饰器模式;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
        setRadius(decoratedShape);
        setBackground(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("画边界颜色: Red");
    }

    private void setRadius(Shape decoratedShape){
        System.out.println("画圆角: 5");
    }

    private void setBackground(Shape decoratedShape){
        System.out.println("画背景: Red");
    }
}
