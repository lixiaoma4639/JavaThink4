package java核心编程.第其他.Reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Test {

    /**
     * 强引用
     */
    public static void main1(String[] args) {
        Object obj = new Object();  // 强引用
        System.gc();  // 强制垃圾回收（仅用于演示，生产环境不推荐）
        System.out.println("GC后强引用对象: " + obj);  // 对象仍然存在
    }

    /**
     * 软引用
     */
    public static void main2(String[] args) {
        SoftReference<byte[]> softRef = new SoftReference<>(new byte[1024 * 1024]); // 1MB
        byte[] data = softRef.get();  // 获取引用对象
        System.gc();
        if (data == null) {
            System.out.println("被回收了。。");
            // 对象已被回收，需要重新创建
            data = new byte[1024 * 1024];
            softRef = new SoftReference<>(data);
        }
        System.out.println("没被回收");
    }

    /**
     * 弱引用
     */
    public static void main(String[] args) throws InterruptedException {
        // 当key不再被强引用时，整个条目会被自动移除
        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
        Object key = new Object();
        weakMap.put(key, "Value");
        System.out.println(weakMap);
        key = null;  // 取消强引用
        System.gc();  // 触发GC后，weakMap会自动清空这个条目
        System.out.println(weakMap);

        //当obe被释放后，ref会在下一次gc时，将包裹到obe释放，适合在android中包裹activity
        Object obe = new Object();
        WeakReference<Object> ref = new WeakReference<>(obe);
        System.out.println(ref.get());
        obe = null;
        for (int i = 0; i < 5; i++) {
            System.gc();
            System.runFinalization();
            Thread.sleep(100);
        }
        System.out.println(ref.get());
    }
}
