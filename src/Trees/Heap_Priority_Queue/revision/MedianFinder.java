package Trees.Heap_Priority_Queue.revision;

import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> small =
            new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> large =
            new PriorityQueue<>();

    public void addNum(int num){

        small.add(num);
        large.add(small.poll());

        if(large.size()>small.size())
            small.add(large.poll());
    }

    public double findMedian(){

        if(small.size()>large.size())
            return small.peek();

        return (small.peek()+large.peek())/2.0;
    }

    public static void main(String[] args){

        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(2);

        System.out.println(mf.findMedian());

        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
