package LinkedLists.DSA_Circular_Singly_Linked_List;


// CSLL Reverse Display,  Code with reverseDisplay()

class Node10 {
    int data;
    Node10 next;

    Node10(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseDisplay {

    private Node10 head = null;
    private Node10 tail = null;

    // Insert at End
    public void insertAtEnd(int data) {
        Node10 newNode = new Node10(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Insert at Position
    public void insertAtPosition(int pos, int data) {
        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Node10 newNode = new Node10(data);
        if (pos == 1) {
            if (head == null) {
                head = tail = newNode;
                newNode.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
            return;
        }

        Node10 temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }
    }

    // Delete from Beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Delete from End
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node10 temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
    }

    // Delete at Position
    public void deleteAtPosition(int pos) {
        if (head == null || pos < 1) {
            System.out.println("Invalid operation");
            return;
        }

        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        Node10 temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Position out of range");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
    }

    // Update at Position
    public void updateAtPosition(int pos, int data) {
        if (head == null || pos < 1) {
            System.out.println("Invalid operation");
            return;
        }

        Node10 temp = head;
        for (int i = 1; i < pos && temp.next != head; i++) {
            temp = temp.next;
        }

        temp.data = data;
    }

    // Search by Value
    public boolean searchByValue(int value) {
        if (head == null) return false;

        Node10 temp = head;
        do {
            if (temp.data == value)
                return true;
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    // Delete by Value
    public void deleteByValue(int value) {
        if (head == null) return;

        if (head.data == value) {
            deleteFromBeginning();
            return;
        }

        Node10 temp = head;
        while (temp.next != head && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next.data == value) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
        } else {
            System.out.println("Value not found!");
        }
    }

    // Display List
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node10 temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Reverse Display using Stack
    public void reverseDisplay() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        Node10 temp = head;
        do {
            stack.push(temp.data);
            temp = temp.next;
        } while (temp != head);

        System.out.print("Reverse: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        ReverseDisplay csll = new ReverseDisplay();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.display();             // List: 10 20 30

        csll.insertAtPosition(2, 15);
        csll.display();             // List: 10 15 20 30

        csll.deleteFromBeginning();
        csll.display();             // List: 15 20 30

        csll.deleteFromEnd();
        csll.display();             // List: 15 20

        csll.deleteAtPosition(2);
        csll.display();             // List: 15

        csll.insertAtEnd(25);
        csll.insertAtEnd(35);
        csll.updateAtPosition(2, 50);
        csll.display();             // List: 15 50 35

        System.out.println("Found 15? " + csll.searchByValue(15)); // true
        csll.deleteByValue(50);
        csll.display();             // List: 15 35

        csll.reverseDisplay();      // Reverse: 35 15
    }
}
