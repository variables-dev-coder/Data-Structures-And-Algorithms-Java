package Practices.Week_3;


// MergeTwoSortedLists.java
class ListNode {
    int val;
    ListNode next;

    ListNode(int v) {
        val=v;
    }
}

public class MergeTwoSortedLists {
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { tail.next = l1; l1 = l1.next; }
            else { tail.next = l2; l2 = l2.next; }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void print(ListNode h){
        while(h!=null){ System.out.print(h.val+" "); h=h.next; } System.out.println();
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1); a.next = new ListNode(3); a.next.next = new ListNode(5);
        ListNode b = new ListNode(2); b.next = new ListNode(4); b.next.next = new ListNode(6);
        System.out.print("A: "); print(a);
        System.out.print("B: "); print(b);
        ListNode m = merge(a,b);
        System.out.print("Merged: "); print(m);
    }
}

//A: 1 3 5
//B: 2 4 6
//Merged: 1 2 3 4 5 6