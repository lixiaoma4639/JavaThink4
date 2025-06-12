package java核心编程.第18章IO系统.FIle类;

import java.io.File;

/**
 * 日期 : 2021/1/21.
 * 创建 : xin.li
 * 描述 :
 */
class MakeDir {
    public static void main(String[] args) {
        File path = new File("./src/java核心编程/第18章IO系统/FIle类/MakeDir.java");
        System.out.println(path.getAbsolutePath());
        System.out.println(path.getPath());
        System.out.println(path.getName());
        System.out.println(path.canRead());
        System.out.println(path.canWrite());
        System.out.println(path.getParent());
        System.out.println(path.length());
        System.out.println(path.lastModified());
    }
}
