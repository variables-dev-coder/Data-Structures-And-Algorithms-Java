package HASH_MAPS;

import java.util.*;

public class LRUCache {
    /**
     * Problem: Design Least Recently Used (LRU) cache
     * Concept: HashMap for O(1) access + Doubly Linked List for O(1) rearrangement
     * Time: O(1) for both get and put
     */
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCacheImpl {
        private Map<Integer, Node> cache;
        private int capacity;
        private Node head, tail;

        public LRUCacheImpl(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();

            // Dummy head and tail for easier operations
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }

            Node node = cache.get(key);
            // Move to front (most recently used)
            removeNode(node);
            addToFront(node);

            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                // Update existing node
                Node node = cache.get(key);
                node.value = value;
                removeNode(node);
                addToFront(node);
            } else {
                // Create new node
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToFront(newNode);

                // Check capacity
                if (cache.size() > capacity) {
                    // Remove least recently used (from tail)
                    Node lru = tail.prev;
                    removeNode(lru);
                    cache.remove(lru.key);
                }
            }
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    }

    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(2);

        System.out.println("=== LRU Cache ===");
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Get 1: " + cache.get(1)); // 1
        cache.put(3, 3); // evicts key 2
        System.out.println("Get 2: " + cache.get(2)); // -1
        cache.put(4, 4); // evicts key 1
        System.out.println("Get 1: " + cache.get(1)); // -1
        System.out.println("Get 3: " + cache.get(3)); // 3
        System.out.println("Get 4: " + cache.get(4)); // 4
        System.out.println("Concept: HashMap + Doubly Linked List for O(1) operations");
    }
}

/*
=== LRU Cache ===
Get 1: 1
Get 2: -1
Get 1: -1
Get 3: 3
Get 4: 4
Concept: HashMap + Doubly Linked List for O(1) operations

LRU Cache
Concept Used: HashMap + Doubly Linked List

Key Concept: HashMap provides O(1) access, Doubly Linked List maintains order for O(1) rearrangement.
 */