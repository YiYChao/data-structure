package top.chao.stack;
/**
 *  @Description: 自定义栈的接口定义
 *  @author: YiYChao
 *  @Date: 2020/1/15 11:53
 *  @Version: V1.0
 */
public interface Stack<E> {

    // 入栈
    void push(E e);
    // 弹栈
    E pop();
    // 查看栈顶元素
    E peek();
    // 获取站内元素个数
    int getSize();
    // 判断栈是否为空
    boolean isEmpty();
}
