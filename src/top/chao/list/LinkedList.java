package top.chao.list;

/**
 * @Description: 自定义列表的相关操作接口定义
 * @author: YiYChao
 * @Date: 2020/1/16 10:22
 * @Version: V1.0
 */
public class LinkedList<E> {

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

    private Node dummyHead;     // 设置虚拟头节点，不存储数据E
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中元素的个数
    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index（0-based）位置添加新的元素
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Fail, Index out of range!" + index);

        Node prev = dummyHead;   // 定义记录要插入元素的前一个节点
        // 由于是找到要插入位置之前的节点，且prev已经赋值为dummyHead，所以条件为index
        for (int i = 0; i < index; i++)
            prev = prev.next;

//        Node node = new Node(e);    // 创建新的节点
//        node.next = prev.next;      // 新节点的后续节点设置为前节点的后续节点
//        prev.next = node;           // 前节点的后续节点设置为新节点

        prev.next = new Node(e, prev.next);  // 与上述代码等价
        size++;
    }

    // 在链表头添加新的元素
    public void addFirst(E e) {
//        Node node = new Node(e);    // 创建一个新的节点
//        node.next = head;       // 将新节点的next指向已存在的链表头
//        head = node;            // 将新节点设置为链表头

//        head = new Node(e, head);    // 等价于上述操作
//        size++;
        add(0, e);
    }

    // 在链表尾添加新的元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index（0-based）个位置的元素
    public E get(int index) {
        // 判断索引是否合法，且包含了链表为空的情况
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add Fail, Index out of range!" + index);
        Node curr = dummyHead.next;     // 标记当前节点，从索引为0的元素开始
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.e;
    }

    // 获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表的最后一个元素
    public E getLast() {
        return get(getSize() - 1);
    }

    // 修改链表的第index（0-based）个位置的元素为e
    public void set(int index, E e) {
        // 判断索引是否合法，且包含了链表为空的情况
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add Fail, Index out of range!" + index);
        Node curr = dummyHead.next;     // 标记当前节点，从索引为0的元素开始
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.e = e;     // 修改当前元素的节点
    }

    // 查找列表中是否存在元素e
    public boolean contains(E e) {
        Node curr = dummyHead.next;     // 标记当前节点，从索引为0的元素开始
        // 遍历链表
        while (curr != null) {
            // 查找到元素
            if (curr.e.equals(e))
                return true;
            curr = curr.next;
        }
        return false;
    }

    // 从链表中删除index（0-based）位置的元素，返回删除的元素e
    public E remove(int index) {
        // 判断索引是否合法，且包含了链表为空的情况
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add Fail, Index out of range!" + index);
        Node prev = dummyHead;
        for (int i = 0; i <index; i++) {
            prev = prev.next;
        }
        Node rstNode =prev.next;    // 记录当前要删除的元素的节点
        prev.next = rstNode.next;   // 进行指针修改，即进行删除操作
        rstNode.next = null;        // 彻底删除，有利于GC回收
        size --;
        return rstNode.e;
    }

    // 从链表删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表删除最后一个元素
    public E removeLast(){
        return remove(getSize() -1);
    }

    @Override
    public String toString() {
        StringBuilder rst = new StringBuilder();
        rst.append("LinkedLlist: head:");
        // 遍历链表
        Node curr = dummyHead.next;     // 标记当前节点，从索引为0的元素开始
        while (curr != null) {
            rst.append(curr + "->");
            curr = curr.next;
        }
        rst.append("NULL");
        return rst.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            listStack.push(i);
            System.out.println(listStack);
        }
        listStack.pop();
        System.out.println(listStack);
    }

}
