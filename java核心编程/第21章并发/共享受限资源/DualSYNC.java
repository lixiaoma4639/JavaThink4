package java核心编程.第21章并发.共享受限资源;

/**
 * 日期 : 2020/12/22.
 * 创建 : xin.li
 * 描述 : f() 和 g()
 */
class DualSYNC {
    private Object object = new Object();

    public synchronized void f(){
        for (int i = 0; i < 5; i++) {
            System.out.println("f()...");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (object){
            for (int i = 0; i < 5; i++) {
                System.out.println("g()...");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        final DualSYNC dualSYNC = new DualSYNC();
        new Thread(){
            @Override
            public void run() {
                dualSYNC.f();
            }
        }.start();
        dualSYNC.g();
    }
}
