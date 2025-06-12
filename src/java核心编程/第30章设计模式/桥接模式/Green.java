package java核心编程.第30章设计模式.桥接模式;

// 新增绿色实现（不涉及形状修改）
public class Green implements Color {
    @Override
    public void applyColor() {
        System.out.print("绿色");
    }
}
