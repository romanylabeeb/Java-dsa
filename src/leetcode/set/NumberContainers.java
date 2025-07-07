package leetcode.set;

import java.util.*;

class NumberContainers {

    Map<Integer, PriorityQueue<Integer>> nodeMap;
    Map<Integer, Integer> indMap;

    public NumberContainers() {
        nodeMap = new HashMap();
        indMap = new HashMap();
    }

    public void change(int index, int number) {
        // prev
        int prevNo = indMap.getOrDefault(index, -1);
        if (prevNo > 0) {
            PriorityQueue<Integer> pq = nodeMap.get(prevNo);
            pq.remove(index);
        }
        // update current;
        if (!nodeMap.containsKey(number)) {
            nodeMap.put(number, new PriorityQueue<>());
        }
        nodeMap.get(number).offer(index);
        indMap.put(index, number);
    }

    public int find(int number) {
        PriorityQueue<Integer> node = nodeMap.get(number);
        return node == null||node.isEmpty()?-1  : node.peek();
    }

    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        obj.find(10);
        obj.change(1, 10);
        int v = obj.find(10);
        obj.change(1, 20);
        v = obj.find(10);
        v = obj.find(20);
        v = obj.find(30);
//        obj.change(3, 10);
//        obj.change(5, 10);
//         v = obj.find(10);
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */