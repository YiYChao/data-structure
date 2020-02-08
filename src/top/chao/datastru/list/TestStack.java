package top.chao.datastru.list;

import top.chao.datastru.stack.ArrayStack;
import top.chao.datastru.stack.Stack;

import java.util.Random;

public class TestStack {

    public static double testStack(Stack<Integer> stack, int opCount){
        long begin = System.nanoTime();
        // 入栈操作
        for (int i = 0; i < opCount; i++)
            stack.push(new Random().nextInt(Integer.MAX_VALUE));
        // 出栈操作
        for (int i = 0; i < opCount; i++)
            stack.pop();
        long end = System.nanoTime();
        // 返回消耗的时间
        return (end - begin) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        System.out.println("ListStack:" + testStack(new LinkedListStack<>(),opCount));
        System.out.println("ArrayStack:" + testStack(new ArrayStack<>(), opCount));
    }
}
