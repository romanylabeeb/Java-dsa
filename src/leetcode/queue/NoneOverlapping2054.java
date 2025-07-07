package leetcode.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class EventData{
    int val;
    int start;
    int end;
    public EventData(int start,int end,int val){
        this.start=start;
        this.end=end;
        this.val=val;
    }
}
public class NoneOverlapping2054 {
    public static int maxTwoEvents(int[][] events) {
        PriorityQueue<EventData> pg=new PriorityQueue<>( (e1,e2)->Integer.compare(e1.start,e2.start));
        Map<Integer,Integer>m=new HashMap<>();
        for(int[]e:events){
            pg.add(new EventData(e[0],e[1],e[2]));
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] events={{1,3,2},{4,5,2},{2,4,3}};
        int g=maxTwoEvents(events);
    }
}
