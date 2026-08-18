package queue_Deque;

public class DequeExample11 {

    static class MyDeque {

        private int[] deque;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyDeque(int capacity) {

            this.capacity = capacity;
            deque = new int[capacity];

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
        }

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
        }

        public int removeFirst() {

            if (isEmpty()) {
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

        public int removeLast() {

            if (isEmpty()) {
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

        MyDeque history = new MyDeque(5);

        // Add pages from the rear
        history.addLast(100);
        history.addLast(200);
        history.addLast(300);

        history.display();

        // Add pages from the front
        history.addFirst(50);
        history.addFirst(25);

        history.display();

        // Remove oldest/front page
        System.out.println(
                "Remove first: " + history.removeFirst()
        );

        history.display();

        // Remove newest/rear page
        System.out.println(
                "Remove last: " + history.removeLast()
        );

        history.display();

        // Add again at both ends
        history.addFirst(10);
        history.addLast(400);

        history.display();

    }
}
