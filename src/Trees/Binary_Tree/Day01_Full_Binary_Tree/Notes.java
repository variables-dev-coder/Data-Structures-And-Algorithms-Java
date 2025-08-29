package Trees.Binary_Tree.Day01_Full_Binary_Tree;

public class Notes {
    public static void main(String[] args) {
        /*
1) Definition (crystal clear)

A Full Binary Tree (FBT) is a binary tree where every node has either 0 or 2 children.
No node is allowed to have exactly one child.

2) Quick visuals ( full vs  not full)

 Full
       A
     / \
    B   C
       / \
      D   E

A has 2 children, B & C have either 0 or 2 children → full.
 Not Full (one-child node exists)

     A
   /
  B
   \
    C

B has exactly one child → not full.



3) Key points (what to remember)

Every internal node has exactly 2 children.
Every leaf node has 0 children.
If a tree has N nodes, it must satisfy these counts:
    Internal nodes = (N - 1) / 2
    Leaf nodes = (N + 1) / 2
Therefore, N is always odd for a full binary tree.


4) The formulas (with proof)

Let:

i = number of internal nodes
l = number of leaf nodes
N = i + l (total nodes)
In any tree, edges = N - 1
In a full BT, each internal node contributes 2 edges (to its two children), so edges = 2i

Set them equal:

2i = N - 1
2i = (i + l) - 1
⇒ i = l - 1
⇒ l = i + 1

Substitute back for N:

N = i + l = i + (i + 1) = 2i + 1
⇒ i = (N - 1)/2
⇒ l = (N + 1)/2

Done



5) Real-life / CS examples

-Expression Trees (for binary operators):
    Operators (+ - * /) are internal nodes (always 2 operands), operands are leaves.
    Hence expression trees for binary operators are typically full.

-Huffman Coding Tree (compression):
    Built by merging the two least-frequency nodes repeatedly → forms a full tree.

-Knockout Tournaments (1v1):
    Each match has exactly two inputs (players/teams). Internal nodes = matches,
    leaves = initial participants → full.


6) Full vs Complete vs Perfect (don’t mix them!)

-Full Binary Tree:
    Every node has 0 or 2 children.
    (Shape can be uneven; last level need not be packed.)

-Complete Binary Tree:
    All levels filled except possibly the last, and the last is filled left to right.
    (Used by Heaps; nodes packed like an array.)

-Perfect Binary Tree:
    All leaves at the same level and every internal node has 2 children.
    (So perfect ⇒ full, but full ⇏ perfect.)

Mini check:

    If you see any node with one child → not full.
    If nodes fill level-by-level with no gaps (array-like) → complete.
    If all leaves line up at the same depth and everyone else has 2 kids → perfect.


7) Tiny practice (for confidence)

For this tree:

      A
     / \
    B   C
       / \
      D   E

N = 5 → Internal = (5-1)/2 = 2 (A, C), Leaves = (5+1)/2 = 3 (B, D, E)  Full.

For this tree:
    A
   / \
  B   C
     /
    D

C has one child →  Not full.


Example 1 – Small Full Binary Tree
       A
      / \
     B   C

Here:
    Root = A
    A has 2 children (B and C).
    B and C have 0 children.
        This is a Full Binary Tree.

Example 2 – Bigger Full Binary Tree

        A
       / \
      B   C
     / \   \
    D   E   F   ❌

A → 2 children (ok)
B → 2 children (ok)
C → only 1 child ❌ (not allowed)
❌ This is NOT a Full Binary Tree.

Example 3 – Correct Full Binary Tree with more nodes

          A
         / \
        B   C
       / \ / \
      D  E F  G

Every node has either:
    0 children (D, E, F, G)
    2 children (A, B, C)
        ✅ This is a Full Binary Tree.

✅ Key Reminder

Full Binary Tree Rule:
Every node → either 0 children (leaf) OR 2 children (internal).
No node can have just 1 child.


         */
    }
}
