package Trees.Heap_Priority_Queue.revision;

import java.util.*;

class Node {
    int value, arr, index;
    Node(int v,int a,int i){
        value=v; arr=a; index=i;
    }
}

public class MergeKSortedArrays {

    public static List<Integer> merge(int[][] arrays){

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a,b)->a.value-b.value);

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<arrays.length;i++)
            pq.add(new Node(arrays[i][0],i,0));

        while(!pq.isEmpty()){

            Node cur = pq.poll();
            result.add(cur.value);

            if(cur.index+1 < arrays[cur.arr].length){
                pq.add(new Node(
                        arrays[cur.arr][cur.index+1],
                        cur.arr,
                        cur.index+1
                ));
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] arr = {{1,4,7},{2,5,8},{3,6,9}};
        System.out.println(merge(arr));
    }
}
