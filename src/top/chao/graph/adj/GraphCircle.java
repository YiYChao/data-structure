package top.chao.graph.adj;

/**
 *  @Description: 检测图中是否存在环
 *  @author: YiYChao
 *  @Date: 2020/2/11 16:40
 *  @Version: V1.0
 */
public class GraphCircle {

    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;

    public GraphCircle(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(dfs(v, v)){
                    hasCycle = true;
                    break;
                }
    }

    // 从顶点 v 开始，判断图中是否有环
    private boolean dfs(int v, int parent){

        visited[v] = true;
        for(int w: G.adj(v))
            if(!visited[w]){
                if(dfs(w, v)) return true;
            }
            else if(w != parent)
                return true;
        return false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){

        Graph g = new Graph("src/top/chao/graph/adj/graph1.txt");
        GraphCircle cycleDetection = new GraphCircle(g);
        System.out.println(cycleDetection.hasCycle());

        Graph g2 = new Graph("src/top/chao/graph/adj/graph2.txt");
        GraphCircle cycleDetection2 = new GraphCircle(g2);
        System.out.println(cycleDetection2.hasCycle());
    }
}