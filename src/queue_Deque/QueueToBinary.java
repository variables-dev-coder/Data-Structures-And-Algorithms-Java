package queue_Deque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueToBinary {

    public static List<String> generateBinary(int n) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        // Start with binary number 1
        queue.offer("1");

        for (int i = 1; i <= n; i++) {

            // Remove front
            String current = queue.poll();

            // Store result
            result.add(current);

            // Generate next binary numbers
            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 5;

        List<String> result = generateBinary(n);

        System.out.println(result);
    }
}
