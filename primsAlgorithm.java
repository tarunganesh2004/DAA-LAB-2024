public class primsAlgorithm {
    private static final int V = 5;

    static int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    static void printMST(int parent[], int graph[][]) {
        System.out.println(" Edge \t\tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " <-> " +           i + " \t" + graph[i][parent[i]]);
        }
    }

    // Function to construct and print MST for a graph represented using adjacency matrix representation
    static void primMST(int graph[][]) {
        int[] parent = new int[V];
        int[] key = new int[V];


        Boolean mstSet[] = new Boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0;

        // First node is always root of MST
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {

            // pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        
        printMST(parent, graph);
    }
    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };
        primMST(graph);
    }
    
}
