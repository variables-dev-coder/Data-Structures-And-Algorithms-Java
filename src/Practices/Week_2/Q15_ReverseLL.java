package Practices.Week_2;


class Noder {
    int val;
    Noder next;

    Noder(int v) {
        val=v;
    }
}

public class Q15_ReverseLL {
    public static Noder reverse(Noder head){
        Noder prev=null, curr=head;

        while(curr!=null){
            Noder next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args){
        Noder n1=new Noder(1);
        n1.next=new Noder(2);
        n1.next.next=new Noder(3);

        Noder newHead = reverse(n1);

        while(newHead!=null){
            System.out.print(newHead.val+" ");
            newHead=newHead.next;
        }
    }
}

// 3 2 1