package Trees.Binary_Tree.Day03_Perfect_Binary_Tree;

public class Notes {
    public static void main(String[] args) {

        /*

Concept – Perfect Binary Tree
Definition:
    A binary tree in which:
    All internal nodes have exactly 2 children.
    All leaves are at the same depth/level.
    In short: completely filled binary tree.

Key Formulas
    For a Perfect Binary Tree of height h (root at level 1):
1.Total Nodes (N):
    N=2h−1

2.Leaf Nodes (L):
    L=2h−1

3.Internal Nodes (I):
    I=N−L=2h−1−1

Full vs Perfect Binary Tree (Difference)
| Feature  | Full Binary Tree               | Perfect Binary Tree               |
| -------- | ------------------------------ | --------------------------------- |
| Children | Each node has 0 or 2 children  | Each internal node has 2 children |
| Leaves   | Can be at **different levels** | All leaves are at **same level**  |
| Example  | \`\`\`                         |                                   |

   A
 /   \
B     C

/
D E
|
A
/
B C
/ \ /
D E F G


---

## Example with Height Calculation
Take a **Perfect Binary Tree of height = 3**

   A
 /   \
B     C

/ \ /
D E F G


- Height (h) = 3
- Total Nodes (N) = 2^3 – 1 = 7
- Leaf Nodes (L) = 2^(3-1) = 4 → (D, E, F, G)
- Internal Nodes (I) = 7 – 4 = 3 (A, B, C)

---

## Proof of Formula
Every level doubles the nodes:

- Level 1 → 1 node
- Level 2 → 2 nodes
- Level 3 → 4 nodes
- … Level h → 2^(h-1) nodes

So total = geometric series:
\[
N = 1 + 2 + 4 + … + 2^{h-1} = 2^h - 1
\]

---

## Practice Problems

### **Problem 1: Count Nodes in a Perfect Binary Tree**
**Input:** Height h = 4
**Output:** 15
**Explanation:**
N = 2^4 – 1 = 15

Dry Run:
Level1=1, Level2=2, Level3=4, Level4=8 → Total=15

---

### **Problem 2: Find number of leaf nodes**
**Input:** Height h = 5
**Output:** 16
**Explanation:**
L = 2^(5-1) = 16

Dry Run:
Level1=1, Level2=2, Level3=4, Level4=8, Level5=16 → Leaves=16

---

### **Problem 3 (LeetCode style): Check if a Binary Tree is Perfect**
Given a binary tree, return `true` if it’s Perfect, else `false`.

Steps:
1. Find height of tree.
2. Count total nodes.
3. If total nodes == 2^h – 1 → it’s Perfect.

---





         */


    }
}
