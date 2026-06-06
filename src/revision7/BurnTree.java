package revision7;

import java.util.*;

class Node25 {

    int data;
    Node25 left;
    Node25 right;

    Node25(int data) {
        this.data = data;
    }
}

public class BurnTree {

    static Map<Node25, Node25> parent =
            new HashMap<>();

    static Node25 targetNode = null;

    static void markParents(
            Node25 root,
            int target) {

        Queue<Node25> queue =
                new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            Node25 curr =
                    queue.poll();

            if (curr.data == target) {
                targetNode = curr;
            }

            if (curr.left != null) {

                parent.put(
                        curr.left,
                        curr);

                queue.offer(
                        curr.left);
            }

            if (curr.right != null) {

                parent.put(
                        curr.right,
                        curr);

                queue.offer(
                        curr.right);
            }
        }
    }

    static int burn(Node25 root,
                    int target) {

        markParents(
                root,
                target);

        Queue<Node25> queue =
                new LinkedList<>();

        Set<Node25> visited =
                new HashSet<>();

        queue.offer(targetNode);

        visited.add(
                targetNode);

        int time = 0;

        while (!queue.isEmpty()) {

            int size =
                    queue.size();

            boolean burned =
                    false;

            for (int i = 0;
                 i < size;
                 i++) {

                Node25 curr =
                        queue.poll();

                if (curr.left != null &&
                        !visited.contains(
                                curr.left)) {

                    burned = true;

                    visited.add(
                            curr.left);

                    queue.offer(
                            curr.left);
                }

                if (curr.right != null &&
                        !visited.contains(
                                curr.right)) {

                    burned = true;

                    visited.add(
                            curr.right);

                    queue.offer(
                            curr.right);
                }

                Node25 par =
                        parent.get(curr);

                if (par != null &&
                        !visited.contains(
                                par)) {

                    burned = true;

                    visited.add(par);

                    queue.offer(par);
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }

    public static void main(String[] args) {

        Node25 root =
                new Node25(1);

        root.left =
                new Node25(2);

        root.right =
                new Node25(3);

        root.left.left =
                new Node25(4);

        root.left.right =
                new Node25(5);

        System.out.println(
                burn(root, 5));
    }
}
