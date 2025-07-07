package dsa.mustafaSaad.graph;

import java.util.Arrays;

public class MainGraph {
    public static void main(String[] args) {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);
        v0.neighbors = Arrays.asList(v1, v5, v6);
        v1.neighbors = Arrays.asList(v3, v4, v5);
        v4.neighbors = Arrays.asList(v2, v6);
        v6.neighbors = Arrays.asList(v0);
        GBFS<Integer> gbfs = new GBFS<>(v0);
        gbfs.traverse();

        GDFS<Integer> integerGDFS = new GDFS<>(v0);
        v0.visited = false;
        v1.visited = false;
        v2.visited = false;
        v3.visited = false;
        v4.visited = false;
        v5.visited = false;
        v6.visited = false;
        System.out.println("DFS");
        integerGDFS.traverse();

        v0.visited = false;
        v1.visited = false;
        v2.visited = false;
        v3.visited = false;
        v4.visited = false;
        v5.visited = false;
        v6.visited = false;
        System.out.println("\nDFS recursively");
        integerGDFS.traverseRecursively(v0);
    }
}