package LinkedLists.DSA_Circular_Doubly_Linked_List;


class CDLLNode {
    int data;
    CDLLNode prev;
    CDLLNode next;

    CDLLNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class CircularDoublyLinkedList {

    private CDLLNode head = null;

    // Insert at end
    public void insertAtEnd(int data) {
        CDLLNode newNode = new CDLLNode(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }
        CDLLNode last = head.prev;
        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
    }

    // Insert at beginning
    public void insertAtBeginning(int data) {
        insertAtEnd(data);
        head = head.prev;
    }

    // Insert at specific position (1-based index)
    public void insertAtPosition(int pos, int data) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }

        CDLLNode newNode = new CDLLNode(data);
        CDLLNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        CDLLNode last = head.prev;
        head = head.next;
        head.prev = last;
        last.next = head;
    }

    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        CDLLNode last = head.prev;
        CDLLNode secondLast = last.prev;
        secondLast.next = head;
        head.prev = secondLast;
    }

    // Delete from specific position
    public void deleteAtPosition(int pos) {
        if (head == null || pos <= 0) {
            System.out.println("Invalid position or list is empty");
            return;
        }
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        CDLLNode temp = head;
        for (int i = 1; i < pos && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp == head) {
            System.out.println("Position out of bounds");
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Update at position
    public void updateAtPosition(int pos, int newData) {
        if (head == null || pos <= 0) {
            System.out.println("Invalid position or list is empty");
            return;
        }

        CDLLNode temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds");
                return;
            }
        }
        temp.data = newData;
    }

    // Search by value
    public int searchByValue(int value) {
        if (head == null) return -1;
        CDLLNode temp = head;
        int pos = 1;
        do {
            if (temp.data == value)
                return pos;
            temp = temp.next;
            pos++;
        } while (temp != head);
        return -1; // Not found
    }

    // Delete by value
    public void deleteByValue(int value) {
        if (head == null) return;
        CDLLNode temp = head;
        do {
            if (temp.data == value) {
                if (temp == head)
                    deleteFromBeginning();
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Value not found");
    }

    // Reverse display
    public void reverseDisplay() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        CDLLNode temp = head.prev;
        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != head.prev);
        System.out.println();
    }

    // Forward display
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        CDLLNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.insertAtEnd(10);
        cdll.insertAtEnd(20);
        cdll.insertAtEnd(30);
        cdll.insertAtBeginning(5);
        cdll.insertAtPosition(3, 15);

        System.out.println("Display Forward:");
        cdll.displayForward();  // 5 10 15 20 30

        System.out.println("Display Reverse:");
        cdll.reverseDisplay();  // 30 20 15 10 5

        cdll.deleteFromBeginning();
        cdll.deleteFromEnd();
        cdll.deleteAtPosition(2);

        System.out.println("After Deletions:");
        cdll.displayForward();  // 10 20

        cdll.updateAtPosition(2, 25);
        System.out.println("After Update:");
        cdll.displayForward();  // 10 25

        System.out.println("Search 25: Found at position " + cdll.searchByValue(25));
        cdll.deleteByValue(25);
        cdll.displayForward();  // 10
    }

}

/*
Display Forward:
5 10 15 20 30
Display Reverse:
30 20 15 10 5
After Deletions:
10 20
After Update:
10 25
Search 25: Found at position 2
10

 */