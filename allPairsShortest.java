public class allPairsShortest {
    static int INF = 99999;
    public static void main(String[] args) {
        int[][] graph={
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
            
        };
        int[][] shortestDistances = floydWarshall(graph);
        printSolution(shortestDistances);
    }

    public static int[][] floydWarshall(int[][] graph) {
        int V=graph.length;
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for(int j=0;j<V;j++){
                dist[i][j]=graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    public static void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");

                }

            }
            System.out.println();
        }
    }
}
