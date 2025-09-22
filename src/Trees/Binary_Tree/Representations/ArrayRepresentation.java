package Trees.Binary_Tree.Representations;

//Array Representation (Heap-like)

public class ArrayRepresentation {
    public static void main(String[] args) {
        // Indexing starts at 1 (0 unused for simplicity)
        int[] tree = new int[8];

        tree[1] = 1;   // Root
        tree[2] = 2;   // Left child of root
        tree[3] = 3;   // Right child of root
        tree[4] = 4;   // Left child of node 2
        tree[5] = 5;   // Right child of node 2

        System.out.println("Root: " + tree[1]);
        System.out.println("Left Child of Root: " + tree[2]);
        System.out.println("Right Child of Root: " + tree[3]);
    }
}

/*
Root: 1
Left Child of Root: 2
Right Child of Root: 3

 */