import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class kruskalAnotherImplementation {
    static final int V = 5; // Number of vertices

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };
        kruskalMST(graph);
    }

    public static void kruskalMST(int[][] graph) {
        Edge[] result = new Edge[V - 1];
        Edge[] edges = new Edge[V * V];
        for (int i = 0; i < V * V; ++i)
            edges[i] = new Edge();

        int e = 0;
        for (int i = 0; i < V; ++i) {
            for (int j = i + 1; j < V; ++j) {
                if (graph[i][j] != 0) {
                    edges[e].src = i;
                    edges[e].dest = j;
                    edges[e].weight = graph[i][j];
                    ++e;
                }
            }
        }

        Arrays.sort(edges, 0, e);

        int[] parent = new int[V];

        for (int i = 0; i < V; ++i)
            parent[i] = i;

        int i = 0, count = 0;
        while (count < V - 1 && i < e) {
            Edge next_edge = edges[i++];
            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[count++] = next_edge;
                union(parent, x, y);
            }
        }

        System.out.println("Edge \tWeight");
        for (i = 0; i < V - 1; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
}
