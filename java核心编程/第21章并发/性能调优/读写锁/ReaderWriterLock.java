package java核心编程.第21章并发.性能调优.读写锁;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 日期 : 2021/1/21.
 * 创建 : xin.li
 * 描述 :
 */
class ReaderWriterLock<T> {
    private ArrayList<T> lockList;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterLock(int size , T initValue) {
        lockList = new ArrayList<>(Collections.nCopies(size , initValue));
    }

    public T set(int index , T element){
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            return lockList.set(index , element);
        } finally {
            writeLock.unlock();
        }
    }

    public T get(int index){
       Lock readLock = lock.readLock();
       readLock.lock();
       if (lock.getReadLockCount() > 1){
           System.out.println(lock.getReadLockCount() + " ;");
       }
        try {
            return lockList.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
