package top.chao.datastru.uf;
/**
 *  @Description:基于树的形式实现并查集,优化size
 *  @author: YiYChao
 *  @Date: 2020/2/3 21:39
 *  @Version: V1.0
 */
public class UnionFind3 implements UF {

    int[] parent;   // 记录每个元素的根节点集合
    int[] sz;       // sz[i]表示以i为根的集合中的元素个数

    public UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        if(sz[pRoot] <= sz[qRoot]){
            parent[pRoot] = qRoot;  // 将第一个元素归至第二个元素所在集合
            sz[qRoot] += sz[pRoot];
        }else { // sz[pRoot] > sz[qRoot]
            parent[qRoot] = pRoot;  // 将第二个元素归至第一个元素所在集合
            sz[pRoot] += sz[qRoot];
        }
    }
}
