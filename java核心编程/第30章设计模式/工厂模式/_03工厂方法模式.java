package java核心编程.第30章设计模式.工厂模式;

public class _03工厂方法模式 {

    // 1. 产品接口
    interface Button {
        void render();
        void onClick();
    }

    // 2. 具体产品
    static class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("渲染Windows风格按钮");
        }

        @Override
        public void onClick() {
            System.out.println("Windows按钮点击事件");
        }
    }

    static class MacOSButton implements Button {
        @Override
        public void render() {
            System.out.println("渲染MacOS风格按钮");
        }

        @Override
        public void onClick() {
            System.out.println("MacOS按钮点击事件");
        }
    }

    // 3. 创建抽象工厂
    interface GUIFactory {
        Button createButton();
    }

    // 4. 具体工厂
    static class WindowsFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }
    }

    static class MacOSFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacOSButton();
        }
    }

    // 5. 客户端代码
    public static void main(String[] args) {
        // 根据配置决定使用哪种工厂
        GUIFactory factory = createFactory("macos");

        Button button = factory.createButton();
        button.render();
        button.onClick();
    }

    private static GUIFactory createFactory(String osType) {
        if ("windows".equalsIgnoreCase(osType)) {
            return new WindowsFactory();
        } else if ("macos".equalsIgnoreCase(osType)) {
            return new MacOSFactory();
        }
        throw new IllegalArgumentException("未知操作系统类型");
    }
}
