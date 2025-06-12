package java核心编程.第30章设计模式.builder模式;

public class Test {
    public static void main(String[] args) {
        // 使用Builder创建对象
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
                .storage("1TB SSD")
                .gpu("NVIDIA RTX 3080")
                .os("Windows 11")
                .build();

        System.out.println(gamingPC);

        // 另一个配置
        Computer officePC = new Computer.Builder("Intel i5", "16GB")
                .storage("512GB SSD")
                .build();

        System.out.println(officePC);
    }
}
