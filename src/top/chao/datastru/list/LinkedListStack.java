package top.chao.datastru.list;


import top.chao.datastru.stack.Stack;

/**
 *  @Description: 通过自定义链表实现栈
 *  @author: YiYChao
 *  @Date: 2020/1/16 11:35
 *  @Version: V1.0
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder rst = new StringBuilder();
        rst.append("ListStack: top ");
        rst.append(list);
        return rst.toString();
    }

}
