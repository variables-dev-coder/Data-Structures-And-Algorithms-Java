package Trees.Binary_Tree.Representations;

// Array Representation (Heap-like Indexing)

public class ArrayTree {
    int[] tree;

    ArrayTree(int size) {
        tree = new int[size];
    }

    void setRoot(int val) {
        tree[0] = val;
    }

    void setLeft(int parentIndex, int val) {
        int leftIndex = 2 * parentIndex + 1;
        if (leftIndex < tree.length)
            tree[leftIndex] = val;
    }

    void setRight(int parentIndex, int val) {
        int rightIndex = 2 * parentIndex + 2;
        if (rightIndex < tree.length)
            tree[rightIndex] = val;
    }

    void printTree() {
        for (int val : tree) {
            if (val != 0) System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayTree t = new ArrayTree(10);
        t.setRoot(1);
        t.setLeft(0, 2);
        t.setRight(0, 3);
        t.setLeft(1, 4);
        t.setRight(1, 5);

        // Expected: 1 2 3 4 5
        t.printTree();
    }
}
