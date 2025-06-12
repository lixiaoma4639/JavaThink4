package java核心编程.第30章设计模式.builder模式;

/**
 * Builder模式是一种创建型设计模式，它允许你分步骤创建复杂对象，使得相同的构建过程可以创建不同的表示。
 * 为什么使用Builder模式
 * 解决构造函数参数过多的问题（"伸缩构造函数"问题）
 * 避免使用大量setter方法导致对象处于不一致状态
 * 提供更清晰、更易读的对象创建方式
 * 可以创建不可变对象
 */
public class Computer {

    // 必选参数
    private final String cpu;
    private final String ram;

    // 可选参数
    private final String storage;
    private final String gpu;
    private final String os;

    // 私有构造函数
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
    }

    // 静态Builder类
    public static class Builder {
        // 必选参数
        private final String cpu;
        private final String ram;

        // 可选参数 - 初始化默认值
        private String storage = "1TB HDD";
        private String gpu = "Integrated";
        private String os = "Windows 10";

        // 必选参数的构造函数
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        // 设置可选参数的方法，返回Builder以便链式调用
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder os(String os) {
            this.os = os;
            return this;
        }

        // 构建方法
        public Computer build() {
            return new Computer(this);
        }
    }

    // getter方法
    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
