package top.chao.graph.adj;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *  @Description: 基于红黑树实现的图的基本表示，暂时只支持无向无权图
 *  @author: YiYChao
 *  @Date: 2020/2/8 23:31
 *  @Version: V1.0
 */
public class Graph {
    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    // 通过文件构建邻接表
    public Graph(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();      // 顶点数
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative value");
            adj = new TreeSet[V];
            for(int i = 0; i < V; i ++)
                adj[i] = new TreeSet<>();

            E = scanner.nextInt();      // 边数
            if (E < 0)
                throw new IllegalArgumentException("V must be non-negative value");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                if (a == b)
                    throw new IllegalArgumentException("Self Loop is Detected！");
                if (adj[a].contains(b))
                    throw new IllegalArgumentException("Parallel Edge is Detected！");

                adj[a].add(b) ;
                adj[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 验证邻接表相关参数的有效性
    public void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex" + v + " is invalid");
    }

    // 返回邻接表的顶点个数
    public int V() {
        return V;
    }

    // 返回邻接表的变数
    public int E() {
        return E;
    }

    // 判断两个节点之间是否存在边
    public boolean hashEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    // 返回与顶点V相连的顶点
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    // 返回顶点V的边数
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d  :", v));
            for (int w : adj[v])
                sb.append(String.format("  %d", w));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph("src/top/chao/graph/adj/graph.txt");
        System.out.println(graph);
    }
}
