package java核心编程.第30章设计模式.组合模式;

/**
 * 对应Android中的View类，是所有组件的基类
 */
public abstract class MyView {
    protected String name;
    protected int width;
    protected int height;

    public MyView(String name) {
        this.name = name;
    }

    // 测量方法
    public abstract void measure(int widthMeasureSpec, int heightMeasureSpec);

    // 布局方法
    public abstract void layout(int l, int t, int r, int b);

    // 绘制方法
    public abstract void draw(Canvas canvas);

    // 添加子View（默认不支持，由容器类重写）
    public void addView(MyView view) {
        throw new UnsupportedOperationException("addView not supported");
    }

    // 移除子View（默认不支持，由容器类重写）
    public void removeView(MyView view) {
        throw new UnsupportedOperationException("removeView not supported");
    }

    // 获取子View（默认不支持，由容器类重写）
    public MyView getChildAt(int index) {
        throw new UnsupportedOperationException("getChildAt not supported");
    }

    // 获取子View数量（默认不支持，由容器类重写）
    public int getChildCount() {
        throw new UnsupportedOperationException("getChildCount not supported");
    }
}
