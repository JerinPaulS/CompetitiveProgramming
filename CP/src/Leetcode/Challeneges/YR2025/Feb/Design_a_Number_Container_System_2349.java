package Leetcode.Challeneges.YR2025.Feb;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Design_a_Number_Container_System_2349 {

    Map<Integer,Integer> m;
    Map<Integer, PriorityQueue<Integer>> d;

    public Design_a_Number_Container_System_2349() {
        m = new HashMap<>();
        d = new HashMap<>();
    }

    public void change(int i, int n) {
        if(m.containsKey(i) && m.get(i)==n)
            return;
        m.put(i,n);
        d.computeIfAbsent(n, k->new PriorityQueue<>()).offer(i);
    }

    public int find(int n) {
        if(!d.containsKey(n))
            return -1;
        PriorityQueue<Integer> pq = d.get(n);
        while(!pq.isEmpty() && m.get(pq.peek()) != n)
            pq.poll();
        return pq.isEmpty() ? -1 : pq.peek();
    }

}
