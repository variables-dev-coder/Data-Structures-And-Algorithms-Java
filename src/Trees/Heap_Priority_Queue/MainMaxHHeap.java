package Trees.Heap_Priority_Queue;


class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity) {
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
            if (heap[parent] >= heap[current]) break;

            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
        }
    }

    void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

public class MainMaxHHeap {

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(10);

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(2);

        heap.printHeap();
    }
}
