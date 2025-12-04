package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

public class Notes {

    public static void main(String[] args) {

        /*

BST Day 6 — VALIDATE BST
------------------------

Validating whether a binary tree is a BST is one of the TOP 5 most asked DSA interview questions.

Today’s goal:
  Understand all 3 validation methods
  Know why some fail
  Be able to explain confidently in interviews
  Practice with perfect dry runs


WHY VALIDATION IS IMPORTANT?
---------------------------

A tree looks like a BST but may violate rules deeper inside.

Example:

      10
     /  \
    5   20
       /
      3   ❌ (invalid here)

This tree is NOT a BST, because 3 < 10 but is in the right subtree.


-------------------------------------------------------------------------------


RULES OF A VALID BST
--------------------
    1.All values in the left subtree < root
    2.All values in the right subtree > root
    3.This rule must hold for every node recursively.


-------------------------------------------------------------------------------


THREE WAYS TO VALIDATE BST
--------------------------
Method 1: Min–Max (Range Constraint) → BEST method

Used in interviews (Google, Amazon, Microsoft)
Catches all violations
Time: O(n), Space: O(h)


METHOD 1: MIN–MAX RANGE VALIDATION (MASTER METHOD)
    LOGIC

Each node has a valid range:
    Root: (-∞ , +∞)
    Left child: (-∞ , root.val)
    Right child: (root.val , +∞)
Every node must obey:

min < node.val < max

Java Code (Clean & Correct)
--------------------------

boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

boolean validate(TreeNode node, long min, long max) {
    if (node == null) return true;

    if (node.val <= min || node.val >= max)
        return false;

    return validate(node.left, min, node.val) &&
           validate(node.right, node.val, max);
}

DRY RUN (IMPORTANT)
Tree:
        50
       /  \
     30    70
    / \    / \
  20  40  60  80

Start:
validate(50, -∞, +∞) ✔ OK

Left subtree:
validate(30, -∞, 50) ✔ OK
validate(20, -∞, 30) ✔ OK
validate(40, 30, 50) ✔ OK

Right subtree:
validate(70, 50, +∞) ✔ OK
validate(60, 50, 70) ✔ OK
validate(80, 70, +∞) ✔ OK

No violation → VALID BST.


WHEN DOES IT FAIL? (TRICKY CASE)

Example:

      10
     /  \
    5    15
        /  \
      6    20

6 < 10 but is in right subtree → INVALID.

Method 2: Inorder Traversal (Sorted Check)
✔ KEY IDEA

Inorder traversal of BST → ALWAYS sorted (strictly increasing)

✔ Code

long prev = Long.MIN_VALUE;

boolean isValidBSTInorder(TreeNode root) {
    if (root == null) return true;

    if (!isValidBSTInorder(root.left)) return false;

    if (root.val <= prev) return false;
    prev = root.val;

    return isValidBSTInorder(root.right);
}


When does it fail?

It does NOT detect some structural violations (rare but important).


Method 3: Using Inorder Array
Simple but less optimal.
    1.Perform inorder
    2.Store in list
    3.Check if list is strictly sorted
✔ Clear
❌ Extra space O(n)


WHICH METHOD TO USE IN INTERVIEW?

| Method        | Time | Space | Accuracy       | Use When           |
| ------------- | ---- | ----- | -------------- | ------------------ |
| Min–Max Range | O(n) | O(h)  | ⭐⭐⭐⭐⭐    | Always pick this   |
| Inorder Prev  | O(n) | O(h)  | ⭐⭐⭐⭐      | Good, simpler       |
| Inorder Array | O(n) | O(n)  | ⭐⭐⭐         | Avoid unless asked |


🎯 MASTER-LEVEL INTERVIEW SUMMARY
-----------------------------------

Interviewer: “How will you validate if a binary tree is BST?”
You:

I’ll use the min–max recursive constraint method.
Each node must lie within a valid range (min < val < max).
While traversing left, I update max to current value; while going right, I update min.
Time is O(n), space O(h), and it catches all BST violations.

Perfect. ⭐

         */
    }
}
