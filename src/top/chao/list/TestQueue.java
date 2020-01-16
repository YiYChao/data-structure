package top.chao.list;

import top.chao.queue.ArrayQueue;
import top.chao.queue.LoopQueue;
import top.chao.queue.Queue;

import java.util.Random;

public class TestQueue {
    public static double testQueue(Queue<Integer> queue, int opCount){
        long begin = System.nanoTime();
        for (int i = 0; i < opCount; i++)
            queue.enqueue(new Random().nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            queue.dequeue();
        long end = System.nanoTime();
        return (end - begin) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        System.out.println("Array Queue:" + testQueue(new ArrayQueue<>(),opCount));
        System.out.println("Loop Queue:" + testQueue(new LoopQueue<>(),opCount));
        System.out.println("List Queue:" + testQueue(new LinkedListQueue<>(),opCount));
    }
}
