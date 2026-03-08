package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class KClosestPoints {

    public static int[][] kClosest(int[][] points, int k){

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)->
                        (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));

        for(int[] p: points){

            pq.add(p);
            if(pq.size()>k)
                pq.poll();
        }

        int[][] res = new int[k][2];
        for(int i=0;i<k;i++)
            res[i] = pq.poll();

        return res;
    }

    public static void main(String[] args){

        int[][] points = {{1,3},{-2,2}};
        System.out.println(Arrays.deepToString(kClosest(points,1)));
    }
}
