package Trees.Heap_Priority_Queue;




class MinHeapDelete {

    int[] heap;
    int size;
    int capacity;

    MinHeapDelete(int capacity) {
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

    int deleteMin() {
        if (size == 0) {
            System.out.println("Heap empty");
            return -1;
        }

        int min = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return min;
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

    void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

public class MainDelete {

    public static void main(String[] args) {

        MinHeapDelete heap = new MinHeapDelete(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(2);

        heap.printHeap();

        System.out.println("Deleted: " + heap.deleteMin());
        heap.printHeap();
    }
}
