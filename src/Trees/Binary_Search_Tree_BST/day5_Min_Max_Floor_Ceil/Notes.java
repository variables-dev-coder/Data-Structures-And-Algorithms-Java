package Trees.Binary_Search_Tree_BST.day5_Min_Max_Floor_Ceil;

public class Notes {
    public static void main(String[] args) {

        /*

Min, Max, Floor, Ceil
======================

We'll use this BST as our example:

        50
       /  \
     30    70
    / \    / \
   20 40  60 80

1. Find Minimum in BST
----------------------
Rule: Minimum value is always in the left-most node.

Code:

public static int findMin(Node root) {
    if (root == null) throw new RuntimeException("Tree is empty");
    while (root.left != null) root = root.left;
    return root.value;
}

Dry Run:

Travel left from root:

50 → 30 → 20

----------------------------------------------------------------------------------



2. Find Maximum in BST
----------------------
Rule: Maximum value is in the right-most node.

Code:

public static int findMax(Node root) {
    if (root == null) throw new RuntimeException("Tree is empty");
    while (root.right != null) root = root.right;
    return root.value;
}

Dry Run:

50 → 70 → 80

Max = 80


Most Important: FLOOR & CEIL
----------------------------
Floor(x)
Largest value ≤ x
(Closest smaller or equal)

Ceil(x)
Smallest value ≥ x
(Closest greater or equal)


3. FLOOR in BST
---------------
Logic (Very Important)
    If root.value == x → x is the floor
    If x < root.value → floor must be in left
    If x > root.value → current root is a candidate, go right to find closer one


Code:

public static Integer floor(Node root, int x) {
    Integer floor = null;

    while (root != null) {
        if (root.value == x) {
            return root.value;
        }
        if (x < root.value) {
            root = root.left;
        } else {
            floor = root.value;  // possible answer
            root = root.right;
        }
    }
    return floor;
}

Dry Run: floor(65)

Path:
    65 > 50 → floor = 50 → go right
    65 < 70 → go left
    65 > 60 → floor = 60 → go right
    null → stop
    Floor = 60

Another Example: floor(25)
    25 < 50 → go left
    25 < 30 → go left
    25 > 20 → floor = 20 → go right (null)
    Floor = 20


4. CEIL in BST
Logic:
    If root.value == x → x is the ceil
    If x > root.value → ceil must be in right
    If x < root.value → current node is a candidate, search left

Code:

public static Integer ceil(Node root, int x) {
    Integer ceil = null;

    while (root != null) {
        if (root.value == x) {
            return root.value;
        }
        if (x > root.value) {
            root = root.right;
        } else {
            ceil = root.value; // possible answer
            root = root.left;
        }
    }
    return ceil;
}

Dry Run: ceil(65)

Path:
    65 > 50 → go right
    65 < 70 → ceil = 70 → go left
    65 > 60 → go right (null)
    Ceil = 70


Example: ceil(25)
    25 < 50 → ceil = 50 → go left
    25 < 30 → ceil = 30 → go left
    25 > 20 → go right null
    Ceil = 30



         */
    }
}
