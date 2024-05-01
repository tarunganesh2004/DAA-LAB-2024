import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class kruskalAlgorithm {
    public static List<Edge> kuskalMST(List<Edge> edges, int numVertices) {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);

        int[] parent = new int[numVertices]; // To store parent of each vertex
        for (int i = 0; i < numVertices; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;
        int totalCost = 0;
        for (Edge edge : edges) {
            if (edgeCount == numVertices - 1) {
                break;
            }
            int srcParent = find(parent, edge.src);
            int destParent = find(parent, edge.dest);

            if (srcParent != destParent) {
                result.add(edge);
                // totalCost += edge.weight;
                union(parent, srcParent, destParent);
                edgeCount++;
            }
        }
        for (Edge edge : result) {
            totalCost += edge.weight;
        }
        System.out.println("Total cost of MST: " + totalCost);

        // System.out.println("Total cost of MST: " + totalCost);
        return result;
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[xRoot] = yRoot;
    }
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> result = kuskalMST(edges, 4);
        System.out.println("Edges in MST: ");
        for (Edge ede : result) {
            System.out.println(ede.src + " - " + ede.dest + " : " + ede.weight);
        }
        System.out.println("Total cost of MST: " + result.stream().mapToInt(edge -> edge.weight).sum());
    }
}
