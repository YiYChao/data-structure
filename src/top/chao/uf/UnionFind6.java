package top.chao.uf;
/**
 *  @Description:基于树的形式实现并查集,基于路路径的优化
 *  @author: YiYChao
 *  @Date: 2020/2/3 21:39
 *  @Version: V1.0
 */
public class UnionFind6 implements UF {

    int[] parent;   // 记录每个元素的根节点集合
    int[] rank;     // rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind6(int size){
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        if (p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);    // 查找P元素对应的根节点
        int qRoot = find(q);    // 查找Q元素对应的根节点
        if (pRoot == qRoot)     // 判断两个元素是否在同一个集合
            return;
        // 此时rank比较粗略，
        // 根据两个元素所在树的rank不同判断合并方向，将低的合并到高的上面
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;  // 将第一个元素归至第二个元素所在集合
        }else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;  // 将第二个元素归至第一个元素所在集合
        }else {
            parent[pRoot] = qRoot;  // 将第一个元素归至第二个元素所在集合
            rank[qRoot] += 1;
        }
    }
}
