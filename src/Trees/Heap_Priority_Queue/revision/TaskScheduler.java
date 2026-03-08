package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n){

        int[] freq = new int[26];

        for(char t: tasks)
            freq[t-'A']++;

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for(int f: freq)
            if(f>0) pq.add(f);

        int time = 0;

        while(!pq.isEmpty()){

            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;

            while(cycle>0 && !pq.isEmpty()){

                int cur = pq.poll()-1;
                if(cur>0) temp.add(cur);

                cycle--;
                time++;
            }

            for(int t: temp)
                pq.add(t);

            if(pq.isEmpty())
                break;

            time += cycle;
        }

        return time;
    }

    public static void main(String[] args){

        char tasks[] = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks,2));
    }
}
