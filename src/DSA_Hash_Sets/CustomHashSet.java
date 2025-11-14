package DSA_Hash_Sets;

public class CustomHashSet {
    /**
     * Problem: Implement HashSet from scratch
     * Concept: Use boolean array for direct addressing (since constraints are known)
     * Time: O(1) for all operations, Space: O(1) fixed size
     */
    static class MyHashSet {
        private boolean[] buckets;

        public MyHashSet() {
            // Problem constraint: 0 <= key <= 10^6
            buckets = new boolean[1000001];
        }

        public void add(int key) {
            buckets[key] = true;
        }

        public void remove(int key) {
            buckets[key] = false;
        }

        public boolean contains(int key) {
            return buckets[key];
        }
    }

    public static void main(String[] args) {
        MyHashSet mySet = new MyHashSet();

        System.out.println("Custom HashSet Implementation:");

        mySet.add(1);
        mySet.add(2);
        System.out.println("After adding 1, 2:");
        System.out.println("Contains 1: " + mySet.contains(1));
        System.out.println("Contains 3: " + mySet.contains(3));

        mySet.remove(1);
        System.out.println("After removing 1:");
        System.out.println("Contains 1: " + mySet.contains(1));
        System.out.println("Concept: Direct addressing using boolean array for O(1) operations");
        System.out.println();
    }
}

/*
Custom HashSet Implementation:
After adding 1, 2:
Contains 1: true
Contains 3: false
After removing 1:
Contains 1: false
Concept: Direct addressing using boolean array for O(1) operations

Key Concept: When the key range is limited and known, we can use direct addressing for optimal performance.
 */