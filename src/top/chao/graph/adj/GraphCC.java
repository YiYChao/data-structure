package top.chao.graph.adj;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;

/**
 *  @Description:实现图的联通分量的求解
 *  @author: YiYChao
 *  @Date: 2020/2/11 11:11
 *  @Version: V1.0
 */
public class GraphCC {

    private Graph graph;
    private int visited[];
    private int cccount;        // 用于记录联通分量
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    // 构造函数，进行遍历参数的初始化
    public GraphCC(Graph graph) {
        this.graph = graph;     // 设置图
        visited = new int[graph.V()];   // 设置包含顶点多的个数的数组，记录节点是否被访问
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        for (int i = 0; i < graph.V(); i++) {   // 解决含有多个连通分量的情况
            if (visited[i] == -1){
                dfs(i, cccount);
                cccount ++;     // 统计连通分量的个数
            }
        }
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
    private void dfs(Integer v, int ccid) {
        visited[v] = ccid;
        pre.add(v);
        for (Integer w : graph.adj(v)) {     // 遍历临边节点
            if (visited[w] == -1) {   // 节点还未遍历到
                dfs(w, ccid);         // 递归进行深度遍历
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
        GraphCC ccGraph = new GraphCC(graph);
//        System.out.println(dfs.pre);
//        System.out.println(dfs.post);
        System.out.println("CCCount : " +  ccGraph.getCccount());
        ArrayList<Integer>[] connectedComponent = ccGraph.connectedComponent();
        for (int i = 0; i < connectedComponent.length; i++) {
            System.out.print(i + " : ");
            for (Integer c : connectedComponent[i]){
                System.out.print(c + " ");
            }
            System.out.print("\n");
        }
    }
}
