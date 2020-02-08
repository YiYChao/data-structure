package top.chao.datastru.queue;

import top.chao.datastru.array.Array;

public class ArrayQueue<E> implements Queue<E>{

    Array<E> data;

    public ArrayQueue(int capacity){
        data = new Array<E>(capacity);
    }

    public ArrayQueue(){
        data = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder rst = new StringBuilder();
        rst.append("ArrayQueue: front[");
        for (int i = 0 ; i < data.getSize(); i++){
            rst.append(data.get(i));
            if (i != data.getSize() - 1){
                rst.append(",");
            }
        }
        rst.append("] tail");
        return  rst.toString();
    }
}
