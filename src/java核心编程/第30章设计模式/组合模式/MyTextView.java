package java核心编程.第30章设计模式.组合模式;

/**
 * 叶子节点 - 对应Android中的TextView
 */
public class MyTextView extends MyView {
    private String text;
    private int textColor;

    public MyTextView(String name, String text) {
        super(name);
        this.text = text;
        this.textColor = 1111;
    }

    @Override
    public void measure(int widthMeasureSpec, int heightMeasureSpec) {
        // 简化测量逻辑：根据文本长度确定宽高
        this.width = text.length() * 10;
        this.height = 20;
        System.out.println(name + " 测量完成: " + width + "x" + height);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        System.out.println(name + " 布局完成: (" + l + "," + t + ")-(" + r + "," + b + ")");
    }

    @Override
    public void draw(Canvas canvas) {
        System.out.println(name + " 绘制文本: \"" + text + "\"");
        // 实际Android中这里会调用canvas.drawText()
    }

    public void setTextColor(int color) {
        this.textColor = color;
    }
}
