package Leetcode.Dijkstras;

import java.util.*;

/**
 * 1976. Number of Ways to Arrive at Destination
 *
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
 *
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
 *
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * Output: 4
 * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
 * The four ways to get there in 7 minutes are:
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 * Example 2:
 *
 * Input: n = 2, roads = [[1,0,10]]
 * Output: 1
 * Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n - 1 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 3
 * 0 <= ui, vi <= n - 1
 * 1 <= timei <= 109
 * ui != vi
 * There is at most one road connecting any two intersections.
 * You can reach any intersection from any other intersection.
 */

public class Number_of_Ways_to_Arrive_at_Destination_1976 {

    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        List<List<int []>> adjList = new ArrayList<>();
        long[] shortestTime = new long[n];
        int[] pathCount = new int[n];
        for (int index = 0; index < n; index++)
            adjList.add(new ArrayList<>());
        Arrays.fill(shortestTime, Long.MAX_VALUE);

        for (int[] road : roads) {
            int source = road[0], dest = road[1], cost = road[2];
            adjList.get(source).add(new int[] { dest, cost });
            adjList.get(dest).add(new int[] { source, cost });
        }

        PriorityQueue<long[]> que = new PriorityQueue<>(Comparator.comparingLong(arr -> arr[0]));

        shortestTime[0] = 0;
        pathCount[0] = 1;
        que.add(new long[] { 0, 0 });

        while (!que.isEmpty()) {
            long[] curr = que.poll();
            long curr_cost = curr[0];
            int curr_node = (int) curr[1];

            if (curr_cost > shortestTime[curr_node])
                continue;

            for (int[] road : adjList.get(curr_node)) {
                int dest = road[0], cost = road[1];
                if (curr_cost + cost < shortestTime[dest]) {
                    shortestTime[dest] = curr_cost + cost;
                    pathCount[dest] = pathCount[curr_node];
                    que.add(new long[] { shortestTime[dest], dest });
                } else if (curr_cost + cost == shortestTime[dest]) {
                    pathCount[dest] = (pathCount[dest] + pathCount[curr_node]) % MOD;
                }
            }
        }
        return pathCount[n - 1];
    }

}
