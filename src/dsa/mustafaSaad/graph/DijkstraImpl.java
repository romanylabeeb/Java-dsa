package dsa.mustafaSaad.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GNode implements Comparable<GNode> {
    public String name;
    public int distance=Integer.MAX_VALUE;
    List<GNode> shortestPath = new ArrayList<>();
    Map<GNode, Integer> adjNodes = new HashMap<>();

    public GNode(String name) {
        this.name = name;
    }

    public void addAdjacentNode(GNode node, int weight) {
        adjNodes.put(node, weight);
    }

    @Override
    public int compareTo(GNode o) {
        return Integer.compare(this.distance, o.distance);
    }

}

public class DijkstraImpl {
    public void calcShortPath(GNode src) {
        src.distance = 0;
        Set<GNode> settledNodes = new HashSet<>();
        Queue<GNode> unsettledNodes = new PriorityQueue<>(Collections.singleton(src));
        // loop on unsettledqueue
        while (!unsettledNodes.isEmpty()) {
            GNode cur = unsettledNodes.poll();
            cur.adjNodes.entrySet()
                    .stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), cur);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(cur);
        }

    }

    private void evaluateDistanceAndPath(GNode adjNode, Integer edgeWeight, GNode source) {
        int newDist = source.distance + edgeWeight;
        if (newDist < adjNode.distance) {
            adjNode.distance = newDist;
            adjNode.shortestPath = Stream.concat(source.shortestPath.stream(), Stream.of(source)).toList();
        }
    }

    public static void printPaths(List<GNode> nodes) {
        nodes.forEach(node -> {
            String path = node.shortestPath.stream().
                    map(n -> n.name)
                    .collect(Collectors.joining(" -> "));
            System.out.println(path.isBlank() ?
                    "%s : %s".formatted(node.name, node.distance) :
                    "%s -> %s : %s".formatted(path, node.name, node.distance));
        });

    }

    public static void main(String[] args) {
        DijkstraImpl impl = new DijkstraImpl();
        GNode a = new GNode("A");
        GNode b = new GNode("B");
        GNode c = new GNode("C");
        GNode d = new GNode("D");
        GNode e = new GNode("E");
        GNode f = new GNode("F");

        a.addAdjacentNode(b, 2);
        a.addAdjacentNode(c, 4);

        b.addAdjacentNode(c, 3);
        b.addAdjacentNode(d, 1);
        b.addAdjacentNode(e, 5);

        c.addAdjacentNode(d, 2);

        d.addAdjacentNode(e, 1);
        d.addAdjacentNode(f, 4);

        e.addAdjacentNode(f, 2);
        impl.calcShortPath(a);
        printPaths(Arrays.asList(a, b, c, d, e, f));

    }
}
