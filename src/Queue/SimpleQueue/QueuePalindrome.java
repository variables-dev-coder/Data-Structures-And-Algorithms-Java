package Queue.SimpleQueue;

// Given a queue of integers, check whether it is a palindrome



import java.util.*;

public class QueuePalindrome {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));

        System.out.println("Queue: " + queue);
        if (isPalindrome(queue)) {
            System.out.println("The queue is a palindrome");
        } else {
            System.out.println("The queue is NOT a palindrome");
        }
    }

    public static boolean isPalindrome(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>(queue);
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

//Queue: [1, 2, 3, 2, 1]
//The queue is a palindrome

//Queue: [1, 2, 3, 4]
//The queue is NOT a palindrome