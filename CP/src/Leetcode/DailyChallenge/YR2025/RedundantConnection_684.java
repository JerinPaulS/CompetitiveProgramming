package Leetcode.DailyChallenge.YR2025;

public class RedundantConnection_684 {

    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int num = edges.length;
        parent = new int[num + 1];
        rank = new int[num + 1];

        for (int index = 0; index <= num; index++) {
            parent[index] = index;
            rank[index] = 1;
        }

        for (int edge[] : edges) {
            if (find(edge[0]) == find(edge[1]))
                return edge;
            union(edge[0], edge[1]);
        }
        return new int[0];
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private void union(int node1, int node2) {
        int node1parent = find(node1);
        int node2parent = find(node2);

        if (node1parent != node2parent) {
            if (rank[node1parent] >= rank[node2parent]) {
                parent[node2parent] = node1parent;
                rank[node1parent] += rank[node2parent];
            } else {
                parent[node1parent] = node2parent;
                rank[node2parent] += rank[node1parent];
            }
        }
    }

}
