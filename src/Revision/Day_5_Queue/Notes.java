package Revision.Day_5_Queue;

public class Notes {
    public static void main(String[] args) {

        /*

Part 1: Conceptual Queue Interview Questions
---------------------------------------------


1. Difference between Stack and Queue
-------------------------------------
    Stack → LIFO (Last In First Out), only top accessible.
    Queue → FIFO (First In First Out), both ends accessible (front for delete, rear for insert).
    Example: Stack → Undo operation, Queue → Printer queue.

================================================



2. Why Circular Queue instead of normal queue?
----------------------------------------------
    In a linear array queue, once rear reaches end, space before front is wasted.
    Circular queue connects rear → front (modulo arithmetic), reuses empty slots.
    Efficient in memory usage.


================================================


3. Real-world use cases of Queue
--------------------------------
    Printer spooler
    CPU scheduling (Round Robin)
    Call center waiting line
    BFS in graphs
    Cache implementation

================================================


4. Explain Priority Queue
-------------------------
    A queue where dequeue order is based on priority, not arrival time.
    Example: Hospital emergency room → critical patients treated first.
    In Java: PriorityQueue<Integer> pq = new PriorityQueue<>(); (min-heap).



=================================================


5. Difference between Deque and Queue
-------------------------------------
    Queue → Insertion at rear, deletion at front.
    Deque → Double-ended queue, insertion/deletion allowed at both ends.
    Example: Browser history (Deque), Print jobs (Queue).



==================================================


6. Queue in Java
----------------
    Queue is an interface in Java (java.util).
    Common implementations:
    LinkedList → Doubly linked list implementation.
    ArrayDeque → Resizable array-based, faster than LinkedList.
    PriorityQueue → Heap-based priority queue.



====================================================


7. Time Complexity (Enqueue/Dequeue)
------------------------------------
    Array Queue: O(1) (if circular array), else O(n) for shifting.
    Linked List Queue: O(1) (front/rear pointers).



====================================================


8. Difference: ArrayDeque vs LinkedList
---------------------------------------
    ArrayDeque: Faster, no extra node overhead, not thread-safe.
    LinkedList: Slower (extra node memory), but allows null elements.




======================================================




9. Queue vs PriorityQueue in real apps
--------------------------------------
    Queue → FIFO tasks (e.g., order processing).
    PriorityQueue → Prioritized tasks (e.g., job scheduling, Dijkstra’s algorithm).



======================================================



10. Why Queue in BFS instead of Stack?
--------------------------------------
    BFS explores level by level, requires FIFO → Queue.
    DFS explores deep first, uses LIFO → Stack.


========================================================


         */
    }
}
