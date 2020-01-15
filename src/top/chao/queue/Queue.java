package top.chao.queue;

/**
 *  @Description: 自定义接队列的接口定义
 *  @author: YiYChao
 *  @Date: 2020/1/15 12:26
 *  @Version: V1.0
 */
public interface Queue<E> {

    // 入队列
    void enqueue(E e);
    // 出队列
    E dequeue();
    // 获得队首的元素
    E getFront();
    // 获得队列元素的个数
    int getSize();
    // 判断队列是否为空
    boolean isEmpty();
}
