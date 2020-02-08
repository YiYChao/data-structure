package top.chao.datastru.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;   // 数组实现
    private int front, tail;    // 标记队首和队尾
    private int size;   // 标记队列的元素个数，可以不添加

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];   // 有意识浪费一个空间
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if (front == tail)
            throw new IllegalArgumentException("Queue is empty!");
        E rst = data[front];
        data[front] = null; // 方便垃圾回收
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return rst;
    }

    // 数组扩容与缩容
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }


    @Override
    public E getFront() {
        if (front == tail)
            throw new IllegalArgumentException("Queue is empty!");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public String toString(){
        StringBuilder rst = new StringBuilder();
        rst.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        rst.append("front: [");
        for (int i = front; i != tail; i = (i + 1) % data.length){  // 此处的数组遍历与resize中的遍历方式不同，但作用一样
            rst.append(data[i]);
            if ((i + 1) % data.length != tail)  // 判断是否为末尾
                rst.append(",");
        }
        rst.append("] tail");
        return rst.toString();
    }

    // 测试
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(10);
        for (int i = 0; i < 14; i++){
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }

        }
    }
}
