package java核心编程.第30章设计模式.责任链模式;


// 事件处理器接口
public interface EventHandler {
    boolean dispatchTouchEvent(MotionEvent event);
    boolean onTouchEvent(MotionEvent event);
}
