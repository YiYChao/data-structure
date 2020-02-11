package top.chao.graph.adj;
/**
 *  @Description: 二分图的检测
 *  @author: YiYChao
 *  @Date: 2020/2/11 16:45
 *  @Version: V1.0
 */
public class GraphBipartition {
    private Graph G;

    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite = true;

    public GraphBipartition(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        for(int i = 0; i < G.V(); i ++)
            colors[i] = -1;

        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(!dfs(v, 0)){
                    isBipartite = false;
                    break;
                }
    }

    private boolean dfs(int v, int color){

        visited[v] = true;
        colors[v] = color;
        for(int w: G.adj(v))
            if(!visited[w]){
                if(!dfs(w, 1 - color)) return false;
            }
            else if(colors[w] == colors[v])
                return false;
        return true;
    }

    public boolean isBipartite(){
        return isBipartite;
    }

    public static void main(String[] args){

        Graph g = new Graph("src/top/chao/graph/adj/graph1.txt");
        GraphBipartition bipartitionDetection = new GraphBipartition(g);
        System.out.println(bipartitionDetection.isBipartite);
        // true

        Graph g2 = new Graph("src/top/chao/graph/adj/graph2.txt");
        GraphBipartition bipartitionDetection2 = new GraphBipartition(g2);
        System.out.println(bipartitionDetection2.isBipartite);
        // false

        Graph g3 = new Graph("src/top/chao/graph/adj/graph3.txt");
        GraphBipartition bipartitionDetection3 = new GraphBipartition(g3);
        System.out.println(bipartitionDetection3.isBipartite);
        // true
    }
}
