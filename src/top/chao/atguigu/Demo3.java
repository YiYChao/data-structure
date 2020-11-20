package top.chao.atguigu;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  @Description: 线程不安全的集合类
 *  @author YiYChao
 *  @Date: 2020/11/13 9:09
 *  @version V1.0
 */
public class Demo3 {
    public static void main(String[] args) {
        unsafeList();
//        unsafeSet();
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
////        Map<String, String> map = new ConcurrentHashMap<>();
//        for (int i = 1; i <= 15;i++) {
//            new Thread(() -> {
//                map.put(Thread.currentThread().getName() ,UUID.randomUUID().toString().substring(0, 4));
//                System.out.println(map);
//            }, String.valueOf(i)).start();
//        }
    }

    private static void unsafeSet() {
        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
//        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 15;i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void unsafeList() {
        List<String> list = new ArrayList<>();
//                List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 5;i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}




