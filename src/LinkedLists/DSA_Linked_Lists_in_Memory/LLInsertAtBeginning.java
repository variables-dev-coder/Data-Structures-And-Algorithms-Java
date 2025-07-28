package LinkedLists.DSA_Linked_Lists_in_Memory;


class Node1 {
    int data;
    Node1 next;

    Node1 (int data) {
        this.data = data;
        this.next = null;
    }
}

public class LLInsertAtBeginning {
    Node1 head;

    public void insertAtBeginning(int value) {
        Node1 newNode = new Node1(value);  // create a new node
        newNode.next = head;               // link new node to old head
        head = newNode;                     // Make new node the new head
    }

    // Display the list
    public void display() {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LLInsertAtBeginning list = new LLInsertAtBeginning();

        list.insertAtBeginning(50);
        list.insertAtBeginning(40);
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        list.display();     // 10 -> 20 -> 30 -> 40 -> 50 -> null
    }
}
