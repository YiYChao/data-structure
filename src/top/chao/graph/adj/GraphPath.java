package top.chao.graph.adj;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  @Description: 计算从一个点到另一个点的路径
 *  @author: YiYChao
 *  @Date: [ 16:37
 *  @Version: V1.0
 */
public class GraphPath {

    private Graph G;
    private int s, t;

    private int[] pre;
    private boolean[] visited;

    public GraphPath(Graph G, int s, int t){

        G.validateVertex(s);
        G.validateVertex(t);

        this.G = G;
        this.s = s;
        this.t = t;

        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for(int i = 0; i < pre.length; i ++)
            pre[i] = -1;

        dfs(s, s);
        for(boolean e: visited)
            System.out.print(e + " ");
        System.out.println();
    }

    private boolean dfs(int v, int parent){

        visited[v] = true;
        pre[v] = parent;

        if(v == t) return true;

        for(int w: G.adj(v))
            if(!visited[w])
                if(dfs(w, v))
                    return true;
        return false;
    }

    public boolean isConnected(){
        return visited[t];
    }

    public Iterable<Integer> path(){

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(!isConnected()) return res;

        int cur = t;
        while(cur != s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){

        Graph g = new Graph("src/top/chao/graph/adj/graph1.txt");
        GraphPath path = new GraphPath(g, 0, 6);
        System.out.println("0 -> 6 : " + path.path());

        GraphPath path2 = new GraphPath(g, 0, 5);
        System.out.println("0 -> 5 : " + path2.path());

        GraphPath path3 = new GraphPath(g, 0, 1);
        System.out.println("0 -> 1 : " + path3.path());
    }
}