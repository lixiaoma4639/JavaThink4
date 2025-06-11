package java核心编程.第21章并发.共享受限资源;

/**
 * 日期 : 2020/12/21.
 * 创建 : xin.li
 * 描述 :
 */
class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber(){
        serialNumber++;
        return serialNumber++;
    }
}
