package top.chao.datastru.uf;
/**
 *  @Description:基于树的形式实现并查集
 *  @author: YiYChao
 *  @Date: 2020/2/3 21:39
 *  @Version: V1.0
 */
public class UnionFind2 implements UF {

    int[] parent;   // 记录每个元素的根节点集合

    public UnionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 查找元素P所对应的集合编号。O(h)的复杂度，h为树的高度
    private int find(int p){
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("P out of bound!");
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);    // 查找P元素对应的根节点
        int qRoot = find(q);    // 查找Q元素对应的根节点
        if (pRoot == qRoot)     // 判断两个元素是否在同一个集合
            return;
        parent[pRoot] = qRoot;  // 将第一个元素归至第二个元素所在集合
    }
}
