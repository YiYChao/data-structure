package top.chao.datastru.list;

import top.chao.datastru.queue.Queue;

/**
 * @Description:通过自定义链表来实现队列
 * @author: YiYChao
 * @Date: 2020/1/16 12:06
 * @Version: V1.0
 */
public class LinkedListQueue<E> implements Queue<E> {
    // 内部类
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        // 判断队列是否为空
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty！");
        Node rstNode = head;
        head = rstNode.next;
        rstNode.next = null;
        // 判断出队之后队列是否为空
        if (head == null)
            tail = null;   // 否则会指向第一个已经出队的节点
        size--;
        return rstNode.e;
    }

    @Override
    public E getFront() {
        // 判断队列是否为空
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty！");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder rst = new StringBuilder();
        rst.append("LinkedQueue: front:");
        // 遍历链表
        Node curr = head;     // 标记当前节点，从索引为0的元素开始
        while (curr != null) {
            rst.append(curr + "->");
            curr = curr.next;
        }
        rst.append("NULL tail");
        return rst.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
