package LinkedLists.DSA_Linked_Lists_in_Memory;

// Search by value

public class LL_SearchByValue {

    static class Node14 {
        int data;
        Node14 next;

        Node14(int data) {
            this.data = data;
        }
    }

    Node14 head;

    // Search for value and return its position
    public int searchByValue(int value) {
        Node14 current = head;
        int position = 1;

        while (current != null) {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1; // not found
    }

    // Utility: Insert at end
    public void insertAtEnd(int data) {
        Node14 newNode = new Node14(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node14 temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Utility: Display
    public void display() {
        Node14 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main for testing
    public static void main(String[] args) {

        LL_SearchByValue list = new LL_SearchByValue();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.print("List:");
        list.display();

        int valueToSearch = 30;
        int result = list.searchByValue(valueToSearch);
        if (result != -1)
            System.out.println("Value " + valueToSearch + " found at position " + result);
        else
            System.out.println("Value " + valueToSearch + " not found in list.");
    }
}
