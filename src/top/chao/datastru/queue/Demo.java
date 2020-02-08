package top.chao.datastru.queue;

import java.util.Random;

public class Demo {

    public double testQueue(Queue<Integer> q, int opCount){
        long begin = System.nanoTime();
        // 入队
        for (int i = 0; i < opCount; i++)
            q.enqueue(new Random().nextInt(Integer.MAX_VALUE));
        // 出队
        for (int i = 0; i < opCount; i++)
            q.dequeue();
        long end = System.nanoTime();
        // 计算系统运行所消耗的事件
        return (end - begin) / 1000000000.0;
    }


    public static void main(String[] args) {
//        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
//        for (int i = 0; i < 10; i++){
//            queue.enqueue(i);
//            System.out.println(queue);
//            if (i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//
//        }
        System.out.println("ArrayQueue:" + new Demo().testQueue(new ArrayQueue<>(),1000000));
        System.out.println("LoopQueue:" + new Demo().testQueue(new LoopQueue<>(),1000000));
    }
}
