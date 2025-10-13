package Trees.Binary_Tree.real_world_applications;

public class Notes {
    public static void main(String[] args) {

        /*

2.Expression Trees — Parsing / Evaluation
-----------------------------------------
Expression Trees are binary trees that represent arithmetic or logical expressions.
Used heavily in:
    Compilers / Interpreters (to evaluate mathematical expressions)
    Calculators
    Query engines (SQL, expression parsing)

Example Expression:

(3 + (5 * 2))

Expression Tree Representation:
        +
       / \
      3   *
         / \
        5   2
Each internal node is an operator, and each leaf node is an operand.

Evaluation (Postorder Traversal)
--------------------------------

Evaluate recursively:

eval(node):
  if node is null → return 0
  if node is operand → return value
  left = eval(node.left)
  right = eval(node.right)
  return apply(node.operator, left, right)

Code Example:

class Node {
    String val;
    Node left, right;
    Node(String val) {
     this.val = val;
     }
}

class ExpressionTree {
    public int evaluate(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return Integer.parseInt(root.val);
        int left = evaluate(root.left);
        int right = evaluate(root.right);
        switch (root.val) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
        }
        return 0;
    }
}



2.Search / Index Structures — BST Variants

Binary trees form the foundation of most search and indexing systems.

| Structure                       | Description                       | Use Case                                       |
| ------------------------------- | --------------------------------- | ---------------------------------------------- |
| **BST (Binary Search Tree)**    | Ordered tree; left < root < right | Searching, sorting                             |
| **AVL Tree**                    | Self-balancing BST                | Faster lookups, guaranteed O(log n)            |
| **Red-Black Tree**              | Balanced BST with color rules     | Used in `TreeMap`, `TreeSet`                   |
| **B+ Tree**                     | Multi-level balanced tree         | Used in **Databases (MySQL, PostgreSQL)**      |
| **Segment Tree / Fenwick Tree** | Range query optimization          | Used in **competitive programming**, analytics |



Real-time usage:
----------------
TreeMap in Java → Red-Black Tree
Database indexes → B+ Trees
Memory allocation / scheduling → AVL or Red-Black Trees



3.Heaps — Priority Queues (Binary Tree Form)
--------------------------------------------
Heaps are complete binary trees satisfying heap property:
    Max-Heap: Parent ≥ children
    Min-Heap: Parent ≤ children

Applications:
    Priority Queues (PriorityQueue in Java)
    Heap Sort
    Scheduling Systems
    Graph Algorithms (Dijkstra, Prim)

Binary Tree → Heap → Priority Queue → Real-world scheduling



4.Spatial & Game Trees (Variants)
---------------------------------
Game Development
    Quad Trees → partition 2D game space
    Oct Trees → 3D space (used in graphics engines)
    Minimax Trees → decision-making in games (e.g., Chess, Tic-Tac-Toe)

Computer Graphics / AI
    Used for collision detection, pathfinding, AI moves evaluation


5.Hierarchical Data Representation
----------------------------------
Binary trees are ideal for representing hierarchical relationships, like:
    File systems (Folder → Subfolder → File)
    Organization charts
    XML / JSON document trees
    HTML DOM tree structure
    Example: HTML DOM Tree

    <html>
        <body>
            <div>
                <h1>Hello</h1>
            </div>
        </body>
     </html>

->Represented internally as a tree structure for traversal and rendering.

Summary Table — Real-World Binary Tree Applications

| Area            | Tree Type           | Used For                             |
| --------------- | ------------------- | ------------------------------------ |
| Compilers       | Expression Tree     | Expression parsing & evaluation      |
| Databases       | B/B+ Tree           | Indexing, query optimization         |
| OS / Schedulers | Heap                | Job prioritization                   |
| Games / AI      | Minimax / Quad Tree | Decision making, collision detection |
| Web / Data      | DOM / XML Trees     | Hierarchical document structure      |



         */
    }
}
