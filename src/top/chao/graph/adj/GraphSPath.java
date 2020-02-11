package top.chao.graph.adj;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  @Description:实现图的单源路径的求解
 *  @author: YiYChao
 *  @Date: 2020/2/11 11:31
 *  @Version: V1.0
 */
public class GraphSPath {

    private Graph graph;
    private Integer s;
    private int visited[];
    private int preNode[];      // 记录到达本节点的上一个节点
    private int cccount;        // 用于记录联通分量
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    // 构造函数，进行遍历参数的初始化
    public GraphSPath(Graph graph, int s) {
        graph.validateVertex(s);
        this.graph = graph;     // 设置图
        this.s = s;
        visited = new int[graph.V()];   // 设置包含顶点多的个数的数组，记录节点是否被访问
        preNode = new int[graph.V()];   // 记录到达本节点的上一个节点
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
            preNode[i] = -1;
        }

//        preNode[s] = s;
//        for (int i = 0; i < graph.V(); i++) {   // 解决含有多个连通分量的情况
//            if (visited[i] == -1){
//                dfs(i, cccount, s);
//                cccount ++;     // 统计连通分量的个数
//            }
//            s = (s + 1) % graph.V();    // 可以循环遍历数组
//        }
        dfs(s, 0, s);
    }

    // 获取到目标节点的路径
    public Iterable<Integer> path(int t){
        ArrayList<Integer> path = new ArrayList<>();
        if (!isConnected(s, t)){
            return path;
        }
        int cur = t;
        while (cur != s){
            path.add(cur);
            cur = preNode[cur];
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    // 给出图的连通分量的个数
    public int getCccount(){
        return cccount;
    }

    // 判断两个节点是否同属一个来连通分量
    public boolean isConnected(int s, int t){
        graph.validateVertex(s);
        graph.validateVertex(t);
        return visited[s] == visited[t];
    }

    // 给出每个连通分量所包含的节点
    public ArrayList<Integer>[] connectedComponent(){
        ArrayList<Integer>[] rst = new ArrayList[cccount];
        // 进行数组的初始化
        for (int i = 0; i < cccount; i++) {
            rst[i] = new ArrayList<>();
        }

        for (int i = 0; i < visited.length; i++) {
            rst[visited[i]].add(i);         // visited[i]为所属的连通分量的标识
        }
        return rst;
    }

    // 进行深度优先遍历
    private void dfs(Integer v, int ccid, int source) {
        visited[v] = ccid;
        preNode[v] = source;
        pre.add(v);
        for (Integer w : graph.adj(v)) {     // 遍历临边节点
            if (visited[w] == -1) {   // 节点还未遍历到
                dfs(w, ccid, v);         // 递归进行深度遍历
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
        GraphSPath ccGraph = new GraphSPath(graph, 0);
//        System.out.println(dfs.pre);
//        System.out.println(dfs.post);
//        System.out.println("CCCount : " +  ccGraph.getCccount());
//        ArrayList<Integer>[] connectedComponent = ccGraph.connectedComponent();
//        for (int i = 0; i < connectedComponent.length; i++) {
//            System.out.print(i + " : ");
//            for (Integer c : connectedComponent[i]){
//                System.out.print(c + " ");
//            }
//            System.out.print("\n");
//        }
        System.out.println("0 -> 6: " + ccGraph.path(6));
        System.out.println("0 -> 5: " + ccGraph.path(5));
    }
}
