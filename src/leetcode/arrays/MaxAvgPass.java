package leetcode.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

class RecordClass {
    int total;
    int pass;
    double ratio;
    int added;
    double improve;

    public RecordClass(int pass, int total) {
        this.pass = pass;
        this.total = total;
        ratio = (pass * 1.0 / total);
    }
    public void calcImprove(){
        double nr = (1.0 * pass + 1) / (total + 1);
        improve= nr - ratio;
    }

    public double addExtra() {
        double nr = (1.0 * pass + 1) / (total + 1);
        return nr - ratio;
    }

    public void addOnde() {
        ratio = 1.0 * (++pass) / (++total);
    }


}

public class MaxAvgPass {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        RecordClass[] records = new RecordClass[classes.length];
        for (int i = 0; i < records.length; ++i) {
            records[i] = new RecordClass(classes[i][0], classes[i][1]);
        }
        Comparator<RecordClass> cm = (c1, c2) ->  Double.compare(c2.improve, c1.improve);
        PriorityQueue<RecordClass> pq = new PriorityQueue<>(cm);
        for (RecordClass rec : records) {
            rec.calcImprove();
            pq.offer(rec);
        }

        while ((extraStudents>0)){
            RecordClass rec=pq.poll();
            rec.addOnde();
            rec.calcImprove();
            pq.offer(rec);
            extraStudents--;
        }

        double sum = 0;
        for(RecordClass rec:records){
            sum+=rec.ratio;
        }
        return sum / records.length;
    }

    public static void main(String[] args) {
        int[][] classes = {
                {2, 4}, {3, 9}, {4, 5}, {2, 10}
        };
        int extera = 4;
        MaxAvgPass ob = new MaxAvgPass();
        System.out.println(ob.maxAverageRatio(classes, extera));
    }
}
