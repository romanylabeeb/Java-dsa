package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MyCalendar729 {
    class EventNode {
        int start;
        int end;
        EventNode left, right;

        public EventNode(int s, int e) {
            start = s;
            end = e;
        }
    }

    EventNode root;

    public boolean book(int start, int end) {
        if (root == null) {
            root = new EventNode(start, end);
            return true;
        }
        return update(start, end);
    }

    boolean update(int start, int end) {
        EventNode node = root;
        while (node != null) {
            // check left nodes  end<node.start  // current interval < node
            if (end <= node.start) {
                if (node.left == null) {
                    node.left = new EventNode(start, end);
                    return true;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new EventNode(start, end);
                    return true;
                }
                node = node.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * [47,50],   47 -> 50
         * [33,41],
         * [39,45],
         * [33,42],
         * [25,32],
         * [26,35],
         * [19,25],
         * [3,8],
         * [8,13],
         * [18,27]
         */
        MyCalendar729 obj = new MyCalendar729();
        //[97,100],[33,51],[89,100],[83,100],[75,92],[76,95],
        // [19,30],[53,63],[8,23],[18,37],[87,100],[83,100],
        // [54,67],[35,48],[58,75],[70,89],[13,32],[44,63],
        // [51,62],[2,15]
        obj.book(97, 100);
        obj.book(33, 51);
        obj.book(75, 92);
        obj.book(19, 30);
        obj.book(53, 63);

        obj.book(13, 32);
        // [19,30],[53,63],[8,23],[18,37],[87,100],[83,100],

//        obj.book(26,35);
//        obj.book(3,8);
//        obj.book(8,13);
//        obj.book(18,27);
    }
}
