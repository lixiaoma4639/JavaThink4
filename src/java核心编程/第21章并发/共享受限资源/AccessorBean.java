package java核心编程.第21章并发.共享受限资源;

/**
 * 日期 : 2021/1/22.
 * 创建 : xin.li
 * 描述 :
 */
class AccessorBean {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public AccessorBean(int number) {
        this.number = number;
    }
}
