package java核心编程.第19章枚举;

import java.util.Date;

/**
 * 日期 : 2021/1/3.
 * 创建 : xin.li
 * 描述 :
 */
enum  Constant {

    DATE_TIME{
        String getInfo() {
            return getInfo("ffff");
        }
    };

    String getInfo(String aaa){return aaa;}

    public static void main(String[] args) {
//        System.out.println(values()[0].getInfo());
    }
}
