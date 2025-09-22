package Trees.Binary_Tree.Representations;

// Build Tree Using Array (Level-order Insertion)

public class ArrayTree1 {
    int[] tree;
    int size;

    ArrayTree1(int capacity) {
        tree = new int[capacity + 1]; // 1-based indexing
        size = 0;
    }

    void insert(int value) {
        if (size + 1 >= tree.length) {
            System.out.println("Tree is full!");
            return;
        }
        tree[++size] = value;
    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayTree1 bt = new ArrayTree1(10);
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);

        bt.print(); // 1 2 3 4 5
    }
}
