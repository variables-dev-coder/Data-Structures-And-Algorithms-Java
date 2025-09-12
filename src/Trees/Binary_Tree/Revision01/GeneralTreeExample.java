package Trees.Binary_Tree.Revision01;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GNode {
    String val;
    List<GNode> children;
    GNode(String v) {
        val = v;
        children = new ArrayList<>();
    }
    void add(GNode c) {
        children.add(c);
    }
}

public class GeneralTreeExample {
    // DFS print (preorder style)

    static void printDFS(GNode node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.val);
        for (GNode ch : node.children) printDFS(ch, indent + " ");
    }

    // Level - order (BFS)
    static void printLevelOrder(GNode root) {
        if (root == null) return;
        Queue<GNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            GNode cur = q.poll();
            System.out.print(cur.val + " ");
            for(GNode ch : cur.children) q.add(ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GNode A = new GNode("A");
        GNode B = new GNode("B");
        GNode C = new GNode("C");
        GNode D = new GNode("D");
        GNode E = new GNode("E");
        GNode F = new GNode("F");


        A.add(B); A.add(C);
        B.add(D); B.add(E);

        C.add(F);


        System.out.println("DFS (preorder-style):");
        printDFS(A, "");
        System.out.println("\nLevel-order:");
        printLevelOrder(A);
    }
}

/*
DFS (preorder-style):
A
   B
      D
      E
   C
      F

Level-order:
A B C D E F


Dry-run the DFS recursion (quick)

Call printDFS(A,""):
Print A.
For child B: print B, then D, E (each indent deeper), return.
For child C: print C, then F.
Result order: A, B, D, E, C, F (matching code output).
For level-order: queue flow → print A then enqueue B,C; print B enqueue D,E; print C enqueue F; then D,E,F.

 */