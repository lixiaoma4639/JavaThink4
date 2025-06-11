package java核心编程.第30章设计模式.工厂模式;

public class _04抽象工厂模式 {

    // 1. 抽象产品接口
    interface Checkbox {
        void paint();
    }

    // 2. 具体产品
    static class WindowsCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("渲染Windows风格复选框");
        }
    }

    static class MacOSCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("渲染MacOS风格复选框");
        }
    }

    // 3. 扩展抽象工厂
    interface GUIFactory {
        _03工厂方法模式.Button createButton();
        Checkbox createCheckbox();
    }

    // 4. 具体工厂实现
    static class WindowsFactory implements GUIFactory {
        @Override
        public _03工厂方法模式.Button createButton() {
            return new _03工厂方法模式.WindowsButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    static class MacOSFactory implements GUIFactory {
        @Override
        public _03工厂方法模式.Button createButton() {
            return new _03工厂方法模式.MacOSButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    // 5. 客户端代码
    public static void main(String[] args) {
        GUIFactory factory = createFactory("windows");

        _03工厂方法模式.Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        button.onClick();
        checkbox.paint();
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
