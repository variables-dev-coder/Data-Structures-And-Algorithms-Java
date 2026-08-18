package queue_Deque;

public class CircularQueue22 {

    static class CircularQueue {

        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public CircularQueue(int capacity) {

            this.capacity = capacity;
            queue = new int[capacity];

            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void add(int job) {

            if (isFull()) {
                System.out.println("Queue is full. Cannot add job " + job);
                return;
            }

            rear = (rear + 1) % capacity;

            queue[rear] = job;

            size++;

            System.out.println("Job " + job + " added");
        }

        public int remove() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int job = queue[front];

            front = (front + 1) % capacity;

            size--;

            return job;
        }

        public void display() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            System.out.print("Jobs: ");

            for (int i = 0; i < size; i++) {

                int index = (front + i) % capacity;

                System.out.print(queue[index] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        CircularQueue printerQueue = new CircularQueue(4);

        printerQueue.add(101);
        printerQueue.add(102);
        printerQueue.add(103);
        printerQueue.add(104);

        printerQueue.display();

        // Complete first two jobs
        System.out.println("Printing job: "
                + printerQueue.remove());

        System.out.println("Printing job: "
                + printerQueue.remove());

        printerQueue.display();

        // Reuse the empty spaces
        printerQueue.add(105);
        printerQueue.add(106);

        printerQueue.display();

        // Process remaining jobs
        System.out.println("Printing job: "
                + printerQueue.remove());

        System.out.println("Printing job: "
                + printerQueue.remove());

        System.out.println("Printing job: "
                + printerQueue.remove());

        printerQueue.display();

    }
}
