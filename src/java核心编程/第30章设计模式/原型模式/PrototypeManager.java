package java核心编程.第30章设计模式.原型模式;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager {
    private static Map<String, Test.Graphic> prototypes = new HashMap<>();

    static {
        // 初始化一些原型
        prototypes.put("redRectangle", new Test.Rectangle(100, 50, "红色"));
//        prototypes.put("blueCircle", new Test.Circle(30, "蓝色"));
    }

    public static Test.Graphic getPrototype(String key) {
        return prototypes.get(key).clone();
    }

    public static void addPrototype(String key, Test.Graphic prototype) {
        prototypes.put(key, prototype);
    }

    // 使用原型管理器
    public static void main(String[] args) {
        //当系统需要多种原型时，可以使用原型管理器来管理这些原型，省去了创建对象的麻烦
        Test.Graphic rect1 = PrototypeManager.getPrototype("redRectangle");
        rect1.draw();

        Test.Graphic rect2 = PrototypeManager.getPrototype("redRectangle");
        rect2.draw();

        System.out.println("rect1 == rect2? " + (rect1 == rect2));
    }
}

