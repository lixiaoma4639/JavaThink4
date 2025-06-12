package java核心编程.第12章异常.构造器异常;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 日期 : 2020/11/19.
 * 创建 : xin.li
 * 描述 :
 */
class InputFile {

    private BufferedReader in;

    public static void main1(String[] args) {
        InputFile inputFile = null;
        try {
            inputFile = new InputFile("/Users/lixin/AndroidStudioProjects/dart_space/JavaThink4/src/java核心编程/第11章异常/构造器异常/InputFile.java");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(inputFile.getLine());

        inputFile.dispose();
    }

    public static void main(String[] args) {
        try {
            InputFile inputFile = new InputFile("/Users/lixin/AndroidStudioProjects/dart_space/JavaThink4/src/java核心编程/第11章异常/构造器异常/InputFile.java");
            try {
                String s;
                int i = 1;
                while ((s = inputFile.getLine()) != null);
            } catch (Exception e) {
                System.out.println("catch exception in main");
                e.printStackTrace(System.out);
            } finally {
                inputFile.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile 构造失败");
        }
    }

    public InputFile(String name) throws Exception{
        try {
            in = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            System.out.println("不能打开文件 " + name);
            throw e;
        } catch (Exception e){
            try {
                in.close();
                System.out.println("close 成功");
            } catch (IOException ex) {
                System.out.println("close 未成功");
            }
            throw e;
        } finally {
            System.out.println("finally执行了...");
        }
    }

    public String getLine(){
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose(){
        try {
            in.close();
            System.out.println("close Success");
        } catch (IOException e) {
            System.out.println("close failed");
        }
    }

























}
