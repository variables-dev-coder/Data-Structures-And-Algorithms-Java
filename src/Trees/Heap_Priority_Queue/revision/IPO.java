package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class IPO {

    static class Project {
        int capital;
        int profit;

        Project(int c, int p) {
            capital = c;
            profit = p;
        }
    }

    public static int findMaximizedCapital(int k, int w,
                                           int[] profits,
                                           int[] capital) {

        PriorityQueue<Project> minCapital =
                new PriorityQueue<>((a,b) -> a.capital - b.capital);

        PriorityQueue<Project> maxProfit =
                new PriorityQueue<>((a,b) -> b.profit - a.profit);

        for (int i = 0; i < profits.length; i++)
            minCapital.add(new Project(capital[i], profits[i]));

        for (int i = 0; i < k; i++) {

            while (!minCapital.isEmpty() &&
                    minCapital.peek().capital <= w) {

                maxProfit.add(minCapital.poll());
            }

            if (maxProfit.isEmpty())
                break;

            w += maxProfit.poll().profit;
        }

        return w;
    }

    public static void main(String[] args) {

        int k = 2;
        int w = 0;

        int profits[] = {1,2,3};
        int capital[] = {0,1,1};

        System.out.println(findMaximizedCapital(
                k, w, profits, capital)); // 4
    }
}
