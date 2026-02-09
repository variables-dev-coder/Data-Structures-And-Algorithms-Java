package Trees.Heap_Priority_Queue;


class MinHeap {

    int[] heap;
    int size;
    int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Insert element into Min Heap
    void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        // Step 1: Insert at end
        heap[size] = value;
        int currentIndex = size;
        size++;

        // Step 2: Heapify Up
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (heap[parentIndex] <= heap[currentIndex]) {
                break;
            }

            // Swap parent and current
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[currentIndex];
            heap[currentIndex] = temp;

            currentIndex = parentIndex;
        }
    }

    // Print heap
    void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(2);

        minHeap.printHeap();
    }
}
