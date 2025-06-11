package java核心编程.第30章设计模式.享元设计模式;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心思想
 * 将对象的"不变部分"（内部状态）与"可变部分"（外部状态）分离：
 * 内部状态(Intrinsic)：共享的、不可变的的部分，存储在享元对象中
 * 外部状态(Extrinsic)：非共享的、可变的的部分，由客户端代码维护
 * 模式结构
 * Flyweight（享元接口）：定义共享对象的接口
 * ConcreteFlyweight（具体享元）：实现享元接口的可共享对象
 * UnsharedConcreteFlyweight（非共享享元）：不需要共享的实现
 * FlyweightFactory（享元工厂）：创建和管理享元对象
 *
 * 假设我们开发一个文本编辑器，文档中有成千上万个字符，
 * 无论文档多长，26个字母只会创建26个对象（再加上数量可控的标点符号），而不是每个字符都新建对象
 */
public class TextEditor {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        // 文档中的字符序列
        String document = "No one’s born being good at all things. You become good at things through hard work. You’re not a varsity athlete the first time you play a new sport. You don’t hit every note the first time you sing a song.You’ve got to practice. The same principle applies to your schoolwork. You might have to do a math problem a few times before you get it right. You might have to read something a few times before you understand it.You definitely have to do a few drafts of a paper before it’s good enough to hand in.";
        String font = "Arial";  // 外部状态

        for (char c : document.toCharArray()) {
            Character character = factory.getCharacter(c);
            character.display(font);
        }

        System.out.println("Total characters created: " + factory.getPoolSize());
    }



    // 享元接口
    static interface Character {
        void display(String font);
    }

    // 具体享元 - 字符对象
    static class ConcreteCharacter implements Character {
        private final char symbol;  // 内部状态（不变）

        public ConcreteCharacter(char symbol) {
            this.symbol = symbol;
        }

        @Override
        public void display(String font) {  // font是外部状态（可变）
            System.out.println("Symbol: " + symbol + ", Font: " + font);
        }
    }

    // 享元工厂
    static class CharacterFactory {
        private Map<java.lang.Character, ConcreteCharacter> pool = new HashMap<>();

        public Character getCharacter(char key) {
            if (!pool.containsKey(key)) {
                pool.put(key, new ConcreteCharacter(key));
            }
            return pool.get(key);
        }

        public int getPoolSize() {
            return pool.size();
        }
    }
}
