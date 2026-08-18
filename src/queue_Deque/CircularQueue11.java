package queue_Deque;

public class CircularQueue11 {

    static class CircularQueue {

        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        // Constructor
        public CircularQueue(int capacity) {

            this.capacity = capacity;
            this.queue = new int[capacity];

            front = 0;
            rear = -1;
            size = 0;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check if queue is full
        public boolean isFull() {
            return size == capacity;
        }

        // Add element
        public void enqueue(int value) {

            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            // Move rear circularly
            rear = (rear + 1) % capacity;

            queue[rear] = value;

            size++;

            System.out.println(value + " inserted");
        }

        // Remove element
        public int dequeue() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int value = queue[front];

            // Move front circularly
            front = (front + 1) % capacity;

            size--;

            return value;
        }

        // View first element
        public int peek() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return queue[front];
        }

        // Display queue logically
        public void display() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            System.out.print("Queue: ");

            for (int i = 0; i < size; i++) {

                int index = (front + i) % capacity;

                System.out.print(queue[index] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        CircularQueue queue = new CircularQueue(5);

        // Insert elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

        // Remove elements
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());

        queue.display();

        // Circular behavior
        queue.enqueue(60);
        queue.enqueue(70);

        queue.display();

        // Peek
        System.out.println("Front element: " + queue.peek());

        // Check status
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Is full: " + queue.isFull());

    }
}
