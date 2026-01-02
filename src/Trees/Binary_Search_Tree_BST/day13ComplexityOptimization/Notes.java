package Trees.Binary_Search_Tree_BST.day13ComplexityOptimization;

public class Notes {
    public static void main(String[] args) {

        /*

1. Time & Space Complexity of BST Operations
---------------------------------------------
Core BST Operations

| Operation | Average Case | Worst Case | Why                  |
| --------- | ------------ | ---------- | -------------------- |
| Search    | O(log N)     | O(N)       | Height of tree       |
| Insert    | O(log N)     | O(N)       | Skewed tree          |
| Delete    | O(log N)     | O(N)       | Unbalanced structure |
| Traversal | O(N)         | O(N)       | Visit all nodes      |


2. When & Why BST Becomes Skewed
--------------------------------
Example (Worst Case)

Insert sorted data:

10 → 20 → 30 → 40 → 50


Tree becomes:

10
  \
   20
     \
      30
        \
         40

Result:
    Height = N
    Search time = O(N)
    BST behaves like a Linked List

    This is unacceptable for production systems.


3. Why Self-Balancing Trees Exist
Goal:
Maintain height ≈ log N automatically.

Strategy:
    Detect imbalance
    Fix using rotations


4️⃣ AVL Tree vs Red-Black Tree (Expert Comparison)

| Feature      | AVL Tree  | Red-Black Tree  |
| ------------ | --------- | --------------- |
| Balance      | Strict    | Relaxed         |
| Height       | Smaller   | Slightly taller |
| Rotations    | More      | Fewer           |
| Read-heavy   | Excellent | Good            |
| Write-heavy  | Slower    | Faster          |
| Used in Java | ❌         | ✅               |


Key Insight:

AVL is theoretically optimal,
Red-Black is practically faster.

That’s why Java, C++, Linux kernel choose Red-Black Trees.


5️⃣ Why Red-Black Trees Scale Better (System Insight)
-----------------------------------------------------
Red-Black Trees:
    Allow small imbalance
    Reduce rotations
    Keep insert/delete fast
    Still guarantee O(log N)

Perfect for:
    Compilers
    Runtime libraries
    OS kernels
    Concurrent systems


6️⃣ Space Complexity (Often Ignored, Very Important)
---------------------------------------------------

| Structure | Space                  |
| --------- | ---------------------- |
| BST       | O(N)                   |
| AVL       | O(N) + height metadata |
| Red-Black | O(N) + color bit       |

Red-Black Tree adds 1 bit per node → very memory-efficient.


7️⃣ Real-World System Use Cases
-----------------------------
🗄️ Databases
     B-Trees / B+ Trees (BST concept generalized)
     Indexing, range queries

🧠 Compilers
    Symbol tables
    Scope resolution
    Balanced trees for fast lookup

⚙️ Operating Systems
    Linux scheduler (Red-Black Tree)
    Virtual memory maps

🌐 Application-Level
    TreeMap / TreeSet
    Leaderboards
    Time-series indexing
    Ordered caches

8️⃣ Interview-Level Explanation (Perfect Answer)
-------------------------------------------------
Q: Why not use simple BST everywhere?
------------------------------------
Expert Answer:
Because simple BST can degrade to O(N) in worst cases due to skewed insertions.
Self-balancing trees like Red-Black Trees guarantee logarithmic height, ensuring
predictable performance under all input patterns, which is critical for system-level reliability.

👑 That answer signals senior-level thinking.


9️⃣ Mental Model (System Designer View)
--------------------------------------
    BST → Conceptual model
    AVL → Strict correctness
    Red-Black → Performance & scalability
    B-Tree → Disk & cache efficiency

Each exists for a different system constraint.


         */
    }
}
