package java核心编程.第15章泛型.问题;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 日期 : 2020/12/9.
 * 创建 : xin.li
 * 描述 :
 */
class ClassCasting {
    public static void main(String[] args) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
            List<String> cast = List.class.cast(in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
