package top.chao.atguigu;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Demo4 {
    public static void main(String[] args) {
//         ReentrantLock lock = new ReentrantLock();
//         for (int i = 1; i <= 5;i++) {
//             new Thread(() -> {
//                 try {TimeUnit.SECONDS.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
//             }, String.valueOf(i)).start();
//         }
//         try { TimeUnit.SECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
