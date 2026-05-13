package revision6;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListExample {

    Node head;

    // insert at end
    public void insert(int data) {

        Node newNode = new Node(data);

        // if list empty
        if (head == null) {
            head = newNode;
            return;
        }

        // traverse to last node
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // attach new node
        temp.next = newNode;
    }

    // print linked list
    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        LinkedListExample list = new LinkedListExample();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.display();
    }
}
