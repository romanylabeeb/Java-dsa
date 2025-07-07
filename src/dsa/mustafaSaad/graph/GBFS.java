package dsa.mustafaSaad.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GBFS<T> {
    private final Vertex<T> start;

    public GBFS(Vertex<T> start) {
        this.start = start;
    }

    public void traverse() {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Vertex<T> cur = queue.poll();
                if(cur.visited) continue;
            System.out.print(String.format("Visit Vertex: %d -> ",cur.getData()));
                cur.visited = true;
                for (Vertex<T> v : cur.neighbors) {
                    if (!v.visited) {
                        queue.add(v);
                    }
                }
            }
            System.out.println();
        }
    }
}
//6YQzr/byT64ByQTKUud2CdSq/
//6YQzr/byT64ByQTKUud2CdSq/
