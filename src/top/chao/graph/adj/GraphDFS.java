package top.chao.graph.adj;

import java.util.ArrayList;

/**
 * @Description:实现图的深度优先遍历
 * @author: YiYChao
 * @Date: 2020/2/10 20:19
 * @Version: V1.0
 */
public class GraphDFS {

    private Graph graph;
    private boolean visited[];
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    // 构造函数，进行遍历参数的初始化
    public GraphDFS(Graph graph) {
        this.graph = graph;     // 设置图
        visited = new boolean[graph.V()];   // 设置包含顶点多的个数的数组，记录节点是否被访问
        for (int i = 0; i < graph.V(); i++) {   // 解决含有多个连通分量的情况
            if (!visited[i]){
                dfs(i);
            }
        }
    }

    // 进行深度优先遍历
    private void dfs(Integer v) {
        visited[v] = true;
        pre.add(v);
        for (Integer w : graph.adj(v)) {     // 遍历临边节点
            if (!visited[w]) {   // 节点还未遍历到
                dfs(w);         // 递归进行深度遍历
            }
        }
        post.add(v);
    }

    // 返回深度优先【先序】遍历结果
    public Iterable<Integer> pre() {
        return this.pre;
    }

    // 返回广度优先【后序】遍历结果
    public Iterable<Integer> post() {
        return this.post;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("src/top/chao/graph/adj/graph1.txt");
        GraphDFS dfs = new GraphDFS(graph);
        System.out.println(dfs.pre);
        System.out.println(dfs.post);
    }
}
