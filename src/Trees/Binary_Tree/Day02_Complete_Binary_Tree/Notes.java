package Trees.Binary_Tree.Day02_Complete_Binary_Tree;

public class Notes {

    public static void main(String[] args) {


        /*

Day 2 → Complete Binary Tree step by step (only theory + examples today).

1. Definition
A Complete Binary Tree (CBT) is a binary tree where:
    All levels are completely filled except possibly the last.
    The last level is filled from left to right only.

Example (Complete Binary Tree):
        1
      /   \
     2     3
    / \   /
   4   5 6
Here,
Level 0: 1 → full
Level 1: 2, 3 → full
Level 2: 4, 5, 6 → filled left to right → valid CBT

Example (Not a Complete Binary Tree):
        1
      /   \
     2     3
    /       \
   4         5
Level 2 is not filled left-to-right →  not complete.


2. Basis of Heaps
    Heaps (Min Heap & Max Heap) are always Complete Binary Trees.
    Reason: In heaps, insertion happens level-order, left to right.
    This guarantees O(log n) insertion & deletion.

Example (Max Heap structure is a Complete Binary Tree):
        50
      /    \
     30     40
    /  \   /
   10  20 35
Complete + satisfies heap property.

3. Array Representation
A Complete Binary Tree can be efficiently stored in an array (no pointers needed).

Rules (for node at index i):
    Left child → 2*i + 1
    Right child → 2*i + 2
    Parent → (i-1)/2

Example:
        1
      /   \
     2     3
    / \
   4   5
Array Representation = [1, 2, 3, 4, 5]

Index 0 = 1 → root
Index 1 = 2 → left of 1
Index 2 = 3 → right of 1
Index 3 = 4 → left of 2
Index 4 = 5 → right of 2

4. Level Order Filling
CBT is always filled level by level.
This ensures no gaps.

Example: Insert 1,2,3,4,5,6 one by one:
Insert 1 → [1]

Insert 2 → [1,2]

Insert 3 → [1,2,3]

Insert 4 → [1,2,3,4]

Insert 5 → [1,2,3,4,5]

Insert 6 → [1,2,3,4,5,6]


        1
      /   \
     2     3
    / \   /
   4   5 6


5. Why Heap must be Complete?

If a heap is not complete, array representation breaks.
Example: If a right child exists without a left → array mapping fails.
Complete structure ensures:
    Insertion at last position only → O(1)
    Deletion (root) + heapify → O(log n).


6. Applications
    Heaps (Priority Queues) → Scheduling, CPU jobs.
    Heap Sort → Sorting in O(n log n).
    Efficient Array Storage → No wasted memory.
    Used in Graph Algorithms → Dijkstra, Prim’s (via Min Heap).


Full Binary Tree vs Complete Binary Tree

| Feature            | Full Binary Tree                   | Complete Binary Tree                                        |
| ------------------ | ---------------------------------- | ----------------------------------------------------------- |
| **Definition**     | Every node has **0 or 2 children** | All levels full, except last level filled **left to right** |
| **Node condition** | No node has only 1 child           | Can have 1 child, but must follow level-order filling       |
| **Shape**          | Strict → always 0 or 2 children    | Flexible → looks compact like a heap                        |
| **Example ✅*      | \`\`\`                             |                                                             |

Example
    1
  /   \
 2     3
/ \


4 5
|
1
/
2 3
/ \ /
4 5 6


| **Example ❌** | ```
        1
       /
      2
``` (not full → only 1 child) | ```
        1
      /   \
     2     3
      \
       4
``` (not complete → right child without left) |
| **Use Case** | Theoretical property check (not common in real apps) | **Heap implementation** (Priority Queue, Scheduling, Graphs) |
| **Array Representation** | Not suitable | Very efficient (Heap stored in array) |

---

 **Key Shortcut:**
- **Full** → Focus on **children count rule (0 or 2)**
- **Complete** → Focus on **tree filling order (left to right)**

---



         */



    }
}
