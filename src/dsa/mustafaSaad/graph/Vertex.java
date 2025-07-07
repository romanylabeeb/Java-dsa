package dsa.mustafaSaad.graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
    private final T data;
    public boolean visited;
    public List<Vertex<T>> neighbors = new LinkedList<>();

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
