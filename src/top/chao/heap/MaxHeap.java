package top.chao.heap;

import top.chao.array.Array;

public class MaxHeap<E extends Comparable<E>>{
    private Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        // 从最后一个非叶子节点开始下沉
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    // 判断堆是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 获取指定索引的父节点的索引
    private int parent(int index){
        if (index <= 0)
            throw new IllegalArgumentException("Index out of range,doesn't hava a parent!");
        return (index - 1) / 2;
    }

    // 返回指定节点的左孩子节点的索引值
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回指定节点的右孩子节点的索引值
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);    // 将元素添加值数组末尾
        siftUp(data.getSize() - 1); // 将知道你位置的元素进行上浮
    }

    // 将堆中指定索引位置的元素进行上浮，使之成为合法堆
    private void siftUp(int k){
        // 循环继续的条件，索引大于零，并且根节点值小于孩子节点
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    // 获取堆中的最大元素
    public E findMax(){
        if (data.isEmpty())
            throw new IllegalArgumentException("Heap is Empty,NO maximum value");
        return data.get(0);
    }

    // 移除最大元素
    public E extractMax(){
        E rst = findMax();
        data.swap(0, data.getSize() - 1);   // 将最大元素与最后一个元素调换位置
        data.removeLast();  // 删除最后一个元素
        siftDown(0);        // 将指定索引位置的元素进行下沉
        return rst;
    }

    // 将指定索引位置的元素进行下沉
    private void siftDown(int k){
        // 循环继续的条件，元素还有孩子节点
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            // 左右孩子节点进行大小比较，右孩子节点比较大
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j ++;   //  标记设为右孩子节点
            // 父节点与最大孩子节点进行比较
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(j, k);    // 交换元素，下沉
            k = j;      // 索引相应变更
        }
    }

    // 替换堆内最大的元素
    public E replace(E e){
        E rst = findMax();
        data.set(0, e);     // 先将对内的最大元素替换
        siftDown(0);    // 再将替换再根节点上的元素进行下沉操作
        return rst;
    }
}
