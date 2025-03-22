package Leetcode.UnionFind;

/**
 *
 * 1971. Find if Path Exists in Graph
 *
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 */


public class Find_if_Path_Exists_in_Graph_1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int index = 0; index < n; index++) {
            parent[index] = index;
            rank[index] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], rank, parent);
        }

        return (find(parent, source) == find(parent, destination));
    }

    private void union(int node1, int node2, int[] rank, int[] parent) {
        int node1Parent = find(parent, node1);
        int node2Parent = find(parent, node2);

        if (node1Parent != node2Parent) {
            if (rank[node1Parent] > rank[node2Parent])
                parent[node2Parent] = node1Parent;
            else if (rank[node1Parent] < rank[node2Parent])
                parent[node1Parent] = node2Parent;
            else {
                parent[node2Parent] = node1Parent;
                rank[node1Parent]++;
            }
        }
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node)
            parent[node] = find(parent, parent[node]);
        return parent[node];
    }

}
