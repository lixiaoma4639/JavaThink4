package java核心编程.第18章IO系统.FIle类;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 日期 : 2021/1/21.
 * 创建 : xin.li
 * 描述 :
 */
class DirList {
    public static void main(String[] args) {
        File path = new File("./src/java核心编程/第18章IO系统/FIle类");
        String[] list = path.list(new DirFitter("D.*\\.java"));
        Arrays.sort(list , String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    static class DirFitter implements FilenameFilter{

        private final Pattern pattern;

        public DirFitter(String regex) {
            pattern = Pattern.compile(regex);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
