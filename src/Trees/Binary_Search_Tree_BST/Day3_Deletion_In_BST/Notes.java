package Trees.Binary_Search_Tree_BST.Day3_Deletion_In_BST;

public class Notes {
    public static void main(String[] args) {

        /*

What deletion must handle (the 3 cases)
---------------------------------------
  1.Node with no child (leaf) — remove it directly.
  2.Node with one child — replace the node with its single child.
  3.Node with two children — replace node’s value with inorder successor
    (smallest in right subtree) or inorder predecessor (largest in left subtree),
    then delete that successor/predecessor node.

Using successor keeps structure valid: left subtree < new key < right subtree

Runnable Java program (recursive delete + tests)

public class BSTDeleteMastery {

    static class Node {
        int key;
        Node left, right;
        Node(int k) { key = k; }
    }

    static class BST {
        Node root;

        // Insert (recursive)
        Node insert(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key) node.left = insert(node.left, key);
            else if (key > node.key) node.right = insert(node.right, key);
            // ignoring equal keys (no duplicates) - can be adapted
            return node;
        }

        // Find min node in subtree (used for inorder successor)
        Node minNode(Node node) {
            Node cur = node;
            while (cur != null && cur.left != null) cur = cur.left;
            return cur;
        }

        // Delete key from BST and return new subtree root
        Node delete(Node node, int key) {
            if (node == null) return null;

            // 1) Search for the node to delete
            if (key < node.key) {
                node.left = delete(node.left, key);
            } else if (key > node.key) {
                node.right = delete(node.right, key);
            } else {
                // node.key == key  -> node to be deleted found

                // CASE A: No child (leaf)
                if (node.left == null && node.right == null) {
                    return null; // garbage-collected (in Java)
                }

                // CASE B: One child
                if (node.left == null) {
                    return node.right; // replace node with right child
                } else if (node.right == null) {
                    return node.left;  // replace node with left child
                }

                // CASE C: Two children
                //  - Get inorder successor (smallest in right subtree)
                Node successor = minNode(node.right);
                //  - Copy successor's key to this node
                node.key = successor.key;
                //  - Delete successor in right subtree
                node.right = delete(node.right, successor.key);
            }
            return node;
        }

        // Inorder traversal
        void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.key + " ");
                inorder(node.right);
            }
        }

        // Pretty-print tree (simple, sideways)
        void printSideways(Node node, String prefix) {
            if (node == null) return;
            printSideways(node.right, prefix + "    ");
            System.out.println(prefix + node.key);
            printSideways(node.left, prefix + "    ");
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int k : keys) tree.root = tree.insert(tree.root, k);

        System.out.println("Original tree (inorder):");
        tree.inorder(tree.root);
        System.out.println("\n\nOriginal tree (sideways):");
        tree.printSideways(tree.root, "");

        // Case 1: delete leaf 20
        System.out.println("\n\nDeleting leaf 20...");
        tree.root = tree.delete(tree.root, 20);
        tree.inorder(tree.root);
        System.out.println("\nSideways after deleting 20:");
        tree.printSideways(tree.root, "");

        // Case 2: delete node with one child (delete 30 which now has one child 40)
        System.out.println("\n\nDeleting node 30 (one child)...");
        tree.root = tree.delete(tree.root, 30);
        tree.inorder(tree.root);
        System.out.println("\nSideways after deleting 30:");
        tree.printSideways(tree.root, "");

        // Case 3: delete node with two children (delete 50)
        System.out.println("\n\nDeleting node 50 (two children)...");
        tree.root = tree.delete(tree.root, 50);
        tree.inorder(tree.root);
        System.out.println("\nSideways after deleting 50:");
        tree.printSideways(tree.root, "");
    }
}



Line-by-line dry-runs (precise trace)
Starting tree:

        50
       /  \
     30    70
    / \    / \
   20 40  60 80



Inorder: 20 30 40 50 60 70 80


Case 1 — Delete leaf 20

Call delete(root, 20):

    1. root = 50 → 20 < 50 → recurse left: root.left = delete(30, 20)

    2. at node 30 → 20 < 30 → recurse left: node.left = delete(20, 20)

    3. at node 20 → node.key == 20 → check children: left==null && right==null → return null.

    4. Back to node 30: its left becomes null. Return node 30.

    5. Back to root 50: left updated to node 30 (with left null). Return root.

Resulting inorder: 30 40 50 60 70 80 (but correct sorted is 30 40 50 60 70 80 — note 20 removed)

Tree structure:

        50
       /  \
     30    70
      \    / \
      40  60 80


Case 2 — Delete node 30 which has one child (40)

Call delete(root, 30):

    1. root 50 → 30 < 50 → root.left = delete(30,30)

    2. at node 30 → found. Check children: left==null, right != null (right = 40)

    3. Since left==null and right!=null → return node.right (node 40) to parent.

    4. Parent (50) sets left child to returned node (40).

Resulting inorder: 40 50 60 70 80

Tree structure:

        50
       /  \
     40    70
          / \
         60 80

(This demonstrates replacing node with its single child.)



Case 3 — Delete node 50 which has two children

Call delete(root, 50):

    1. node 50 found. Both left (40) and right (70) are non-null → two-child case.

    2.Find inorder successor = minNode(node.right) → traverse right subtree root
       70 → go left to 60 → left null → successor = 60.

    3.Copy successor key: node.key = 60. Now node (formerly 50) has key 60.

    4.Delete successor key from right subtree: node.right = delete(node.right, 60).
         Call delete on subtree rooted at 70 to delete 60:
             60 < 70 → go left → at node 60 → found. Node 60 has no children → return null.
             Set left child of 70 to null.

    5.Return updated node (root now key=60) up the recursion.

Final tree (inorder): 40 60 70 80
Final structure:

        60
       /  \
     40    70
             \
             80
Note: The original 60 node was removed and its value moved to root, preserving BST property.


Important interview notes & pitfalls
====================================
    -> Why successor? Successor (min in right subtree) is guaranteed > all left subtree and
       <= all other right-subtree nodes — safe to copy.

    -> Predecessor alternative: You can use inorder predecessor (max in left subtree) — symmetric approach.

    -> Duplicate keys: Above code ignores duplicates. Decide a policy: store counts, store duplicates
       to one side (e.g., <= go left), or disallow duplicates.

    -> Be careful with references: In deletion you must assign
       node.left = delete(node.left,key) / node.right = ... so parent links update.

    -> Memory: In Java, returning null lets GC reclaim removed nodes — no manual free needed.

    -> Edge cases: Deleting from empty tree, deleting root repeatedly, deleting
       non-existent key — ensure function returns current root unchanged for not found.

    -> Complexity: Average O(log n), worst-case O(n) when tree is skewed. Deletion also O(h) where h is height.

    -> Testing: After each delete operation, verify with inorder traversal (should remain sorted)
    and a structural print, as included.



Extra mastery tips
===================

Practice by hand: draw the tree and perform delete for nodes at different depths.
Tracing recursion stack on paper is golden.

Implement delete using inorder predecessor and compare behavior.

Try writing an iterative delete (harder: requires parent tracking) — good interview bonus.

After mastering BST delete, learn AVL / Red-Black deletion rules
(rebalancing) — next step to system-level proficiency.


         */
    }
}
