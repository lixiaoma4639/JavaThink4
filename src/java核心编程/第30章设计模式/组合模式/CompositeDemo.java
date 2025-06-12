package java核心编程.第30章设计模式.组合模式;

public class CompositeDemo {
    public static void main(String[] args) {
        // 创建叶子节点
        MyTextView textView1 = new MyTextView("TextView1", "Hello");
        MyTextView textView2 = new MyTextView("TextView2", "World");
        MyTextView textView3 = new MyTextView("TextView3", "Android");

        // 创建复合节点 - 水平布局的ViewGroup
        MyViewGroup horizontalLayout = new MyViewGroup("HorizontalLayout", 0);
        horizontalLayout.addView(textView1);
        horizontalLayout.addView(textView2);

        // 创建复合节点 - 垂直布局的ViewGroup
        MyViewGroup verticalLayout = new MyViewGroup("VerticalLayout", 1);
        verticalLayout.addView(horizontalLayout);
        verticalLayout.addView(textView3);

        // 模拟View系统的测量、布局、绘制流程
        System.out.println("=== 测量过程 ===");
        verticalLayout.measure(0, 0);

        System.out.println("\n=== 布局过程 ===");
        verticalLayout.layout(0, 0, verticalLayout.width, verticalLayout.height);

        System.out.println("\n=== 绘制过程 ===");
        verticalLayout.draw(new Canvas());
    }
}
