package Revision.Day4_LinkedList;

public class Notes {
    public static void main(String[] args) {


        /*
1.What is a Linked List? How is it different from an array?
    Linked List: A linear data structure where elements (nodes) are connected using pointers.
    Each node contains data + reference (next/prev).
Array: A collection of elements stored in contiguous memory locations.

Key differences:

| Feature            | Array                        | Linked List                       |
| ------------------ | ---------------------------- | --------------------------------- |
| Memory allocation  | Contiguous                   | Non-contiguous (dynamic)          |
| Access             | Random access (O(1))         | Sequential access (O(n))          |
| Insertion/Deletion | Costly (O(n))                | Efficient (O(1) if pointer given) |
| Size               | Fixed (unless dynamic array) | Dynamic, can grow/shrink          |


2.Advantages and disadvantages of Linked List?

Advantages:
    Dynamic size (no need to declare size beforehand).
    Efficient insertion/deletion (O(1) if position known).
    No memory wastage due to fixed size like arrays.

Disadvantages:
    No random access (need traversal O(n)).
    Extra memory required for pointers.
    Poor cache locality compared to arrays.
    Traversal is slower.


3.Explain types of Linked Lists: Singly, Doubly, Circular.
    Singly Linked List → Each node has data + next, moves one direction only.
    Doubly Linked List → Each node has data + next + prev, can move both directions.
    Circular Linked List → Last node points back to head.
        Circular Singly → one direction.
        Circular Doubly → both directions, and circular.


4.Why do we need a doubly linked list when singly exists?
    In singly, you cannot go backwards.
    Doubly linked allows bidirectional traversal, easy deletion (O(1)) without needing previous node reference.
    Example: Browser forward/backward navigation, Music Playlist.


5.Real-world applications of Linked Lists.
    Undo/Redo in editors (Doubly).
    Browser forward/backward history (Doubly).
    Music/video playlists (Circular).
    Hashing (chaining in HashTables) (Singly).
    LRU Cache implementation (Doubly + HashMap).
    Dynamic memory allocation (OS uses free list).

6.Compare time complexity of insertion/deletion/search in Array vs Linked List.

| Operation               | Array                                   | Linked List                            |
| ----------------------- | --------------------------------------- | -------------------------------------- |
| Access element by index | O(1)                                    | O(n)                                   |
| Search element          | O(n)                                    | O(n)                                   |
| Insert at head          | O(n)                                    | O(1)                                   |
| Insert at end           | O(1) (amortized, if capacity available) | O(n) (singly), O(1) (doubly with tail) |
| Delete at head          | O(n) (shifting required)                | O(1)                                   |
| Delete at end           | O(1)                                    | O(n) (singly), O(1) (doubly with tail) |


7.Where does Linked List store nodes in memory? (Heap, non-contiguous).
    Each node is allocated dynamically in heap memory.
    Nodes are not stored in contiguous blocks (unlike arrays).
    The OS memory allocator provides memory as needed, and nodes are connected using pointers (references).



         */
    }
}
