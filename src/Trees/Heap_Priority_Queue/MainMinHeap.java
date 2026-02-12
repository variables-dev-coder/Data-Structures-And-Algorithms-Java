package Trees.Heap_Priority_Queue;


class MinHeap2 {

    int[] heap;
    int size;
    int capacity;

    MinHeap2(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    void insert(int value) {
        heap[size] = value;
        int current = size;
        size++;

        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap[parent] <= heap[current]) break;

            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
        }
    }

    void heapifyDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap[left] < heap[smallest])
                smallest = left;

            if (right < size && heap[right] < heap[smallest])
                smallest = right;

            if (smallest == index) break;

            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            index = smallest;
        }
    }

    int getMin() {
        return heap[0];
    }

    void replaceRoot(int value) {
        heap[0] = value;
        heapifyDown(0);
    }
}

public class MainMinHeap {

    public static void main(String[] args) {

        int[] arr = {10, 4, 20, 15, 30, 7, 8};
        int k = 3;

        MinHeap2 heap = new MinHeap2(k);

        // Step 1: Insert first k elements
        for (int i = 0; i < k; i++)
            heap.insert(arr[i]);

        // Step 2: Process remaining elements
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > heap.getMin()) {
                heap.replaceRoot(arr[i]);
            }
        }

        System.out.println("Top " + k + " largest elements:");
        for (int i = 0; i < heap.size; i++)
            System.out.print(heap.heap[i] + " ");
    }
}
