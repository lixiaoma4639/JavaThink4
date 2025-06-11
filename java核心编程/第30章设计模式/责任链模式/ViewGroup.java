package java核心编程.第30章设计模式.责任链模式;

import java.util.ArrayList;
import java.util.List;

public class ViewGroup implements EventHandler {
    private List<EventHandler> mChildren = new ArrayList<>();
    private EventHandler mParent;

    public ViewGroup(EventHandler parent) {
        this.mParent = parent;
    }

    public void addView(EventHandler child) {
        mChildren.add(child);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("ViewGroup dispatchTouchEvent");

        // 1. 先检查是否拦截
        if (onInterceptTouchEvent(event)) {
            return onTouchEvent(event);
        }

        // 2. 不拦截则分发给子View
        for (int i = mChildren.size() - 1; i >= 0; i--) {
            EventHandler child = mChildren.get(i);
            if (child.dispatchTouchEvent(event)) {
                return true;
            }
        }

        // 3. 子View不处理则自己处理
        System.out.println("ViewGroup onTouchEvent， id = " + this);
        return onTouchEvent(event);
    }

    protected boolean onInterceptTouchEvent(MotionEvent event) {
        System.out.println("ViewGroup onInterceptTouchEvent");
        return false; // 默认不拦截
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("ViewGroup onTouchEvent， id = " + this);
        if (mParent != null) {
            return mParent.onTouchEvent(event);
        }
        return false;
    }
}
