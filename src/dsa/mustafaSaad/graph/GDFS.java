package dsa.mustafaSaad.graph;

import java.util.*;

public class GDFS<T> {
    private final Vertex<T> start;

    public GDFS(Vertex<T> start) {
        this.start = start;
    }

    public void traverse() {
        Deque<Vertex<T>> stk = new ArrayDeque<>();
        stk.push(start);
        while (!stk.isEmpty()) {
            Vertex<T> cur = stk.pop();
            if (cur.visited) continue;
            // Visit the current vertex
            System.out.print(String.format("Visit Vertex: %d -> ", cur.getData()));
            cur.visited = true;
            for (int i = cur.neighbors.size() - 1; i >= 0; --i) {
                Vertex<T> v = cur.neighbors.get(i);
                if (!v.visited)
                    stk.push(v);
            }
        }
    }

    public void traverseRecursively(Vertex<T> v) {
        v.visited = true;
        System.out.print(String.format("Visit Vertex: %d -> ", v.getData()));
        v.neighbors.stream().filter(vert -> !vert.visited)
                .forEach(this::traverseRecursively);
    }
}
