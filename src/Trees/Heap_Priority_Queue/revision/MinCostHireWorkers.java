package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class MinCostHireWorkers {

    static class Worker {
        double ratio;
        int quality;

        Worker(double r, int q) {
            ratio = r;
            quality = q;
        }
    }

    public static double mincostToHireWorkers(int[] quality,
                                              int[] wage,
                                              int k) {

        int n = quality.length;

        Worker[] workers = new Worker[n];

        for (int i = 0; i < n; i++) {

            double ratio = (double) wage[i] / quality[i];
            workers[i] = new Worker(ratio, quality[i]);
        }

        Arrays.sort(workers, (a,b) ->
                Double.compare(a.ratio, b.ratio));

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int qualitySum = 0;
        double result = Double.MAX_VALUE;

        for (Worker w : workers) {

            maxHeap.add(w.quality);
            qualitySum += w.quality;

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {

                result = Math.min(
                        result,
                        qualitySum * w.ratio
                );
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int quality[] = {10,20,5};
        int wage[] = {70,50,30};
        int k = 2;

        System.out.println(
                mincostToHireWorkers(quality, wage, k)
        );
    }
}
