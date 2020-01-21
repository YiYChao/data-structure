package top.chao.segment;

/**
 * @Description:自定义线段树
 * @author: YiYChao
 * @Date: 2020/1/21 15:57
 * @Version: V1.0
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length * 4];
        buildTree(0, 0, data.length - 1);
    }

    // 创建以root为根节点的在【left....right】区间的线段树
    private void buildTree(int root, int left, int right) {
        if (left == right) {
            tree[root] = data[left];
            return;
        }
        int leftTree = leftChild(root);     // 左孩子的线段树的根节点
        int rightTree = rightChild(root);   // 右孩子的线段树的根节点
        int mid = left + (right - left) / 2;    // 中间分界
        buildTree(leftTree, left, mid);         // 递归调用
        buildTree(rightTree, mid + 1, right);
        tree[root] = merger.merge(tree[leftTree], tree[rightTree]);     // 调用实现接口
    }

    // 获取线段树中元素的个数
    public int getSize() {
        return data.length;
    }

    // 查找线段树中指定索引的元素
    public E get(int index) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("Index out of range!");
        return data[index];
    }

    // 返回一个完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回一个完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 返回区间【queryL，queryR】的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length
                || queryL > queryR)
            throw new IllegalArgumentException("Segment is illegal!");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以root为根节点的【left，right】方位内查找区间【queryL，queryR】区间的值
    private E query(int root, int left, int right, int queryL, int queryR) {
        if (left == queryL && right == queryR)
            return tree[root];

        int leftTree = leftChild(root);     // 左孩子的线段树的根节点
        int rightTree = rightChild(root);   // 右孩子的线段树的根节点
        int mid = left + (right - left) / 2;    // 中间分界

        if (queryL >= mid + 1)      // 目标区间落在右子树
            return query(rightTree, mid + 1, right, queryL, queryR);
        else if (queryR <= mid)     // 目标区间落在左子树
            return query(leftTree, left, mid, queryL, queryR);
        E leftResult = query(leftTree, left, mid, queryL, mid);
        E rightResult = query(rightTree, mid + 1, right, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    // 更新线段树中的元素节点
    public void set(int index, E e) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index out of range!");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int root, int left, int right, int index, E e) {
        // 父节点就是要更新的节点
        if (left == right) {
            tree[root] = e;
            return;
        }
        int leftTree = leftChild(root);     // 左孩子的线段树的根节点
        int rightTree = rightChild(root);   // 右孩子的线段树的根节点
        int mid = left + (right - left) / 2;    // 中间分界

        if (index >= mid + 1)
            set(rightTree, mid + 1, right, index, e);
        else // index <= mid
            set(leftTree, left, mid,index, e);
        tree[root] = merger.merge(tree[leftTree],tree[rightTree]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                builder.append(tree[i]);
            else
                builder.append("null");
            if (i != tree.length - 1)
                builder.append(",");
            else
                builder.append("]");
        }
        return builder.toString();
    }
}
