package java核心编程.第其他.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String path = "/Users/lixin/AndroidStudioProjects/dart_space/JavaThink4/out/production/JavaThink4/java核心编程/第其他/ClassLoader/classes/MyTestClass.class";
        try (FileInputStream fis = new FileInputStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        // 使用自定义ClassLoader加载类
        MyClassLoader myLoader = new MyClassLoader("/src/java核心编程/第其他/ClassLoader/classes");
        Class<?> myClass = myLoader.loadClass("java核心编程.第其他.ClassLoader.classes.MyTestClass");
        Object obj = myClass.newInstance();
        System.out.println("Loaded class: " + obj.getClass());
        System.out.println("Class loader: " + obj.getClass().getClassLoader());
    }
}
