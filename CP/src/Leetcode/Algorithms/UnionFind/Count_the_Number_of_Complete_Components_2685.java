package Leetcode.Algorithms.UnionFind;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * 2685. Count the Number of Complete Components
 *
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
 *
 * Return the number of complete connected components of the graph.
 *
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
 *
 * A connected component is said to be complete if there exists an edge between every pair of its vertices.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
 * Output: 3
 * Explanation: From the picture above, one can see that all of the components of this graph are complete.
 * Example 2:
 *
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
 * Output: 1
 * Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 50
 * 0 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * There are no repeated edges.
 */

public class Count_the_Number_of_Complete_Components_2685 {

    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        HashMap<Integer, Integer> edgeCount = new HashMap<>();

        for (int index=0; index < n; index++)
            parent[index] = index;
        for (int[] edge : edges)
            union(edge[0], edge[1], parent, rank);
        for (int [] edge : edges) {
            int root = find(parent, edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }
        System.out.println(Arrays.toString(rank) + " " + Arrays.toString(parent));

        int result = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            if (find(parent, vertex) == vertex) {
                int nodes = rank[vertex];
                int totalEdges = (nodes * (nodes - 1)) / 2;
                if (edgeCount.getOrDefault(vertex, 0) == totalEdges)
                    result++;
            }
        }
        return result;
    }

    private void union(int node1, int node2, int[] parent, int[] rank) {
        int node1Parent = find(parent, node1);
        int node2Parent = find(parent, node2);

        if (node1Parent != node2Parent) {
            if (rank[node1Parent] > rank[node2Parent]) {
                parent[node2Parent] = node1Parent;
                rank[node1Parent] += rank[node2Parent];
            }
            else {
                parent[node1Parent] = node2Parent;
                rank[node2Parent] += rank[node1Parent];
            }
        }
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node)
            parent[node] = find(parent, parent[node]);
        return parent[node];
    }

}
