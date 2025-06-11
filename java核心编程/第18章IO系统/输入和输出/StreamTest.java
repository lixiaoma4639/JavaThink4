package java核心编程.第18章IO系统.输入和输出;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期 : 2021/1/21.
 * 创建 : xin.li
 * 描述 :
 */
class StreamTest {
    public static void main2(String[] args) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{1 , 2});
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(100);
        try {
            PipedOutputStream pipedOutputStream = new PipedOutputStream(new PipedInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100 ; i++) {
//            fileWriterRead(i);
//        }

//        listFiles();
    }


    public static void fileWriterRead(int i){


        String content = "- 概述:\n" +
                "- FileOutputStream 用于将数据写入文件，FileInputStream 用于从文件读取数据。\n" +
                "- 这是文件操作的基本流类型，处理实际的文件 I/O。\n" +
                "- 使用场景:\n" +
                "- 适用于任何需要存储到磁盘或者从磁盘读取的场景。\n" +
                "- 常用于读取和写入二进制文件。" + i + "\n";

        FileWriter fileWriter = null;
        File logFile = getLogFile("src/java核心编程/第18章IO系统/输入和输出", "logs_" + date2YMDString(new Date()));

        try {
            fileWriter = new FileWriter(logFile, true);

            fileWriter.append(content);

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e1) { /* fail silently */ }
            }
        }
    }

    /**
     * 递归遍历文件夹及子文件夹中的所有文件
     */
    public static void listFiles(String directoryPath) {
        // 获取目录下的所有文件和目录
        File dir = new File(directoryPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 如果是目录，则递归调用
                    System.out.println("目录: " + file.getAbsolutePath());
                    listFiles(directoryPath);
                } else {
                    // 如果是文件，则输出文件路径

                }
            }
        }
    }

    private static final int MAX_BYTES = 10 * 1024; // 500K averages to a 4000 lines per file
    private static File getLogFile( String folderName,  String fileName) {


        File folder = new File(folderName);
        if (!folder.exists()) {
            //TODO: What if folder is not created, what happens then?
            folder.mkdirs();
        }

        int newFileCount = 0;
        File newFile;
        File existingFile = null;

        newFile = new File(folder, String.format("%s_%s.txt", fileName, newFileCount));
        while (newFile.exists()) {
            existingFile = newFile;
            newFileCount++;
            newFile = new File(folder, String.format("%s_%s.txt", fileName, newFileCount));
        }

        if (existingFile != null) {
            if (existingFile.length() >= MAX_BYTES) {
                return newFile;
            }
            return existingFile;
        }

        return newFile;
    }

    public static String date2YMDString(Date date) {
        if (date != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(date);
        }
        return "";
    }
}
