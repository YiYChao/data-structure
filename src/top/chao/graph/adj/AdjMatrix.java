package top.chao.graph.adj;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: 邻接矩阵实现无向无权图
 * @author: YiYChao
 * @Date: 2020/2/8 22:27
 * @Version: V1.0
 */
public class AdjMatrix {
    private int V;
    private int E;
    private int[][] adj;

    // 通过文件构建邻接矩阵
    public AdjMatrix(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();      // 顶点数
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative value");
            adj = new int[V][V];

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
                if (adj[a][b] == 1)
                    throw new IllegalArgumentException("Parallel Edge is Detected！");

                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 验证矩阵相关参数的有效性
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex" + v + " is invalid");
    }

    // 返回矩阵的顶点个数
    public int V() {
        return V;
    }

    // 返回矩阵的边数
    public int E() {
        return E;
    }

    // 判断两个节点之间是否存在边
    public boolean hashEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    // 返回与顶点V相连的顶点
    public ArrayList<Integer> adj(int v){
        validateVertex(v);
        ArrayList<Integer> rst = new ArrayList<>();
        for(int i = 0; i < V; i ++)
            if(adj[v][i] == 1)
                rst.add(i);
        return rst;
    }

    // 返回顶点V的边数
    public int degree(int v){
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                sb.append(String.format("%d  ", adj[i][j]));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("src/top/chao/graph/adj/graph.txt");
        System.out.println(adjMatrix);
    }
}
