package Leetcode.TopologicalSort;

import java.util.*;

/**
 *
 * 210. Course Schedule II
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */


public class Course_Schedule_II_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        generateAdjacencyList(adjList, prerequisites);
        generateInDegreeMatrix(adjList, inDegree);

        Deque<Integer> que = new LinkedList<>();
        for (int vertex = 0; vertex < numCourses; vertex++) {
            if (inDegree[vertex] == 0)
                que.add(vertex);
        }

        List<Integer> result = new ArrayList<>();
        while (que.size() > 0) {
            int curr = que.poll();
            if (adjList.containsKey(curr)) {
                var edges = adjList.get(curr);
                for (int edge : edges) {
                    inDegree[edge] -= 1;
                    if (inDegree[edge] == 0)
                        que.add(edge);
                }
            }
            result.add(curr);
        }

        if (result.size() == numCourses)
            return result.stream().mapToInt(k -> k).toArray();

        return new int[0];
    }

    private void generateAdjacencyList(HashMap<Integer, List<Integer>> adjList, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            adjList.computeIfAbsent(pre[1], val -> new ArrayList<>()).add(pre[0]);
        }
    }

    private void generateInDegreeMatrix(HashMap<Integer, List<Integer>> adjList, int[] inDegree) {
        for (int key : adjList.keySet()) {
            for (int vertex : adjList.get(key))
                inDegree[vertex]++;
        }
    }

}
