package top.chao.stack;

import top.chao.array.Array;

/**
 *  @Description:采用数组的形式实现栈的相关接口
 *  @author: YiYChao
 *  @Date: 2020/1/15 11:57
 *  @Version: V1.0
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> data;  // 采用自定义数组的形式进行栈的实现

    public ArrayStack(int capacity) {
        data = new Array<E>(capacity);
    }

    public ArrayStack() {
        data = new Array<E>();
    }
    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 获取栈的容积
    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder rst = new StringBuilder();
        rst.append("ArrayStact:[");
        for (int i = 0; i < data.getSize(); i++){
            rst.append(data.get(i));
            if (i != data.getSize() - 1)
                rst.append(",");
        }
        rst.append("] top");
        return rst.toString();
    }
}
