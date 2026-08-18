package queue_Deque;

public class DequeUsingArray {

    static class MyDeque {

        private int[] deque;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        // Constructor
        public MyDeque(int capacity) {

            this.capacity = capacity;
            this.deque = new int[capacity];

            front = 0;
            rear = -1;
            size = 0;
        }

        // Check empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check full
        public boolean isFull() {
            return size == capacity;
        }

        // Add element at front
        public void addFirst(int value) {

            if (isFull()) {
                System.out.println("Deque is full");
                return;
            }

            if (size == 0) {

                front = 0;
                rear = 0;

            } else {

                front = (front - 1 + capacity) % capacity;
            }

            deque[front] = value;

            size++;

            System.out.println(value + " added at front");
        }

        // Add element at rear
        public void addLast(int value) {

            if (isFull()) {
                System.out.println("Deque is full");
                return;
            }

            if (size == 0) {

                front = 0;
                rear = 0;

            } else {

                rear = (rear + 1) % capacity;
            }

            deque[rear] = value;

            size++;

            System.out.println(value + " added at rear");
        }

        // Remove element from front
        public int removeFirst() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            int value = deque[front];

            if (size == 1) {

                front = 0;
                rear = -1;

            } else {

                front = (front + 1) % capacity;
            }

            size--;

            return value;
        }

        // Remove element from rear
        public int removeLast() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            int value = deque[rear];

            if (size == 1) {

                front = 0;
                rear = -1;

            } else {

                rear = (rear - 1 + capacity) % capacity;
            }

            size--;

            return value;
        }

        // View first element
        public int peekFirst() {

            if (isEmpty()) {
                return -1;
            }

            return deque[front];
        }

        // View last element
        public int peekLast() {

            if (isEmpty()) {
                return -1;
            }

            return deque[rear];
        }

        // Display deque
        public void display() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return;
            }

            System.out.print("Deque: ");

            for (int i = 0; i < size; i++) {

                int index = (front + i) % capacity;

                System.out.print(deque[index] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        MyDeque deque = new MyDeque(5);

        // Add from rear
        deque.addLast(20);
        deque.addLast(30);
        deque.addLast(40);

        deque.display();

        // Add from front
        deque.addFirst(10);
        deque.addFirst(5);

        deque.display();

        // Peek
        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());

        // Remove from front
        System.out.println("Removed from front: "
                + deque.removeFirst());

        deque.display();

        // Remove from rear
        System.out.println("Removed from rear: "
                + deque.removeLast());

        deque.display();

        // Status
        System.out.println("Is empty: " + deque.isEmpty());
        System.out.println("Is full: " + deque.isFull());
    }
}
