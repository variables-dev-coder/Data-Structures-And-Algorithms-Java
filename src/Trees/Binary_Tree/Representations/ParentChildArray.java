package Trees.Binary_Tree.Representations;


// Parent-Child Access in Array Representation

public class ParentChildArray {
    public static void main(String[] args) {
        int[] tree = {0, 1, 2, 3, 4, 5}; // 0 unused

        int index = 2; // Node 2
        int parent = index / 2;
        int leftChild = index * 2;
        int rightChild = index * 2 + 1;

        System.out.println("Node: " + tree[index]);
        System.out.println("Parent: " + tree[parent]);
        System.out.println("Left Child: " + tree[leftChild]);
        System.out.println("Right Child: " + tree[rightChild]);
    }
}

// Node: 2
//Parent: 1
//Left Child: 4
//Right Child: 5