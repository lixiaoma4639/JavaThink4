package java核心编程.第30章设计模式.享元设计模式;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Random;



// 使用示例
public class ForestGame {
    public static void main(String[] args) {
        List<Tree> forest = new ArrayList<>();

        System.out.println("Generating forest...");

        // 生成10000棵松树和10000棵橡树
        for (int i = 0; i < 10000; i++) {
            forest.add(new Tree(Tree.randomX(), Tree.randomY(),
                    Tree.randomHeight(), "Pine"));
            forest.add(new Tree(Tree.randomX(), Tree.randomY(),
                    Tree.randomHeight(), "Oak"));
        }

        System.out.println("Forest generated with " + forest.size() + " trees.");
        System.out.println("Rendering forest...");

        // 渲染森林（实际游戏中会分批渲染）
        for (int i = 0; i < 10; i++) { // 只渲染前10棵作为示例
            forest.get(i).render();
        }

        System.out.println("Actual tree models created: " + TreeFactory.getModelCount());
        System.out.println("Memory saved by Flyweight pattern!");

    }


    // 树的享元（内部状态）
    static class TreeModel {
        private final String mesh;    // 3D模型数据
        private final String texture; // 贴图
        private final String type;

        public TreeModel(String type) {
            this.type = type;
            this.mesh = loadMesh(type);
            this.texture = loadTexture(type);
        }

        // 模拟加载3D模型数据
        private String loadMesh(String type) {
            switch (type) {
                case "Pine":
                    return "pine_tree.mesh";
                case "Oak":
                    return "oak_tree.mesh";
                default:
                    return "default_tree.mesh";
            }
        }

        // 模拟加载贴图数据
        private String loadTexture(String type) {
            switch (type) {
                case "Pine":
                    return "pine_texture.png";
                case "Oak":
                    return "oak_texture.jpg";
                default:
                    return "default_texture.png";
            }
        }

        public void render(int x, int y, int height) {
            // 在实际游戏中，这里会调用图形API进行渲染
            // 此处简化为打印渲染信息
            System.out.printf("Rendering %s tree at (%d,%d) height %d (Mesh: %s, Texture: %s)\n", type, x, y, height, mesh, texture);
        }

        // 获取类型用于演示
        private String getType() {
            return texture.replace("_texture.png", "")
                    .replace("_texture.jpg", "");
        }
    }

    // 享元工厂
    static class TreeFactory {
        private static final Map<String, TreeModel> cache = new HashMap<>();
        private static int creationCount = 0;

        public static TreeModel getTreeModel(String type) {
            if (!cache.containsKey(type)) {
                cache.put(type, new TreeModel(type));
                creationCount++;
            }
            return cache.get(type);
        }

        public static int getModelCount() {
            return creationCount;
        }
    }

    // 客户端（外部状态：位置和高度）
    static class Tree {
        private int x, y, height;
        private TreeModel model;
        private static Random random = new Random();

        public Tree(int x, int y, int height, String type) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.model = TreeFactory.getTreeModel(type);
        }

        public void render() {
            model.render(x, y, height);
        }

        // 生成随机X坐标 (0-100)
        public static int randomX() {
            return random.nextInt(101);
        }

        // 生成随机Y坐标 (0-100)
        public static int randomY() {
            return random.nextInt(101);
        }

        // 生成随机高度 (5-15)
        public static int randomHeight() {
            return 5 + random.nextInt(11);
        }
    }
}
