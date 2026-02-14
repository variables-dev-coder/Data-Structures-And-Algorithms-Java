package Trees.Heap_Priority_Queue.day2_Heap_Operation;



class MinHeap {

    int[] heap;
    int size;

    MinHeap(int[] arr) {
        heap = arr;
        size = arr.length;
        buildHeap();
    }

    void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
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

            if (smallest == index)
                break;

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

public class Main {
    public static void main(String[] args) {

        int[] arr = {10, 5, 20, 2, 8};

        MinHeap heap = new MinHeap(arr);

        heap.printHeap();
    }
}

// [2, 10, 20, 5, 8]