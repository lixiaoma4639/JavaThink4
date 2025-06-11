package java核心编程.第30章设计模式.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 复合组件 - 对应Android中的LinearLayout
 */
public class MyViewGroup extends MyView {
    private List<MyView> children = new ArrayList<>();
    private int orientation; // 0=水平, 1=垂直

    public MyViewGroup(String name, int orientation) {
        super(name);
        this.orientation = orientation;
    }

    @Override
    public void measure(int widthMeasureSpec, int heightMeasureSpec) {
        int totalWidth = 0;
        int totalHeight = 0;

        // 测量所有子View
        for (MyView child : children) {
            child.measure(widthMeasureSpec, heightMeasureSpec);

            if (orientation == 0) { // 水平布局
                totalWidth += child.width;
                totalHeight = Math.max(totalHeight, child.height);
            } else { // 垂直布局
                totalWidth = Math.max(totalWidth, child.width);
                totalHeight += child.height;
            }
        }

        this.width = totalWidth;
        this.height = totalHeight;
        System.out.println(name + " 测量完成: " + width + "x" + height);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        System.out.println(name + " 布局完成: (" + l + "," + t + ")-(" + r + "," + b + ")");

        int childLeft = l;
        int childTop = t;

        // 布局所有子View
        for (MyView child : children) {
            int childRight = childLeft + child.width;
            int childBottom = childTop + child.height;

            child.layout(childLeft, childTop, childRight, childBottom);

            if (orientation == 0) { // 水平布局
                childLeft += child.width;
            } else { // 垂直布局
                childTop += child.height;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        System.out.println(name + " 开始绘制");
        // 先绘制自己的背景等
        System.out.println(name + " 绘制背景");

        // 然后绘制所有子View
        for (MyView child : children) {
            child.draw(canvas);
        }

        System.out.println(name + " 绘制完成");
    }

    @Override
    public void addView(MyView view) {
        children.add(view);
    }

    @Override
    public void removeView(MyView view) {
        children.remove(view);
    }

    @Override
    public MyView getChildAt(int index) {
        return children.get(index);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }
}
