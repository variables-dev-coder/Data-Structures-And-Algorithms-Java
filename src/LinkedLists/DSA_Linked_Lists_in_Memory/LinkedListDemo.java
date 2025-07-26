package LinkedLists.DSA_Linked_Lists_in_Memory;



 class Node5 {
     int data;
     Node5 next;

     Node5 (int data) {
         this.data = data;
         this.next = null;
     }
 }

 public class LinkedListDemo {
     public static void main(String[] args) {
         Node5 head = new Node5(10);
         head.next = new Node5(20);
         head.next.next = new Node5(30);
         head.next.next.next = new Node5(40);
         head.next.next.next.next = new Node5(50);

         Node5 temp = head;
         while (temp != null) {
             System.out.print(temp.data + " -> ");
             temp = temp.next;
         }
         System.out.println("null");
     }
}
