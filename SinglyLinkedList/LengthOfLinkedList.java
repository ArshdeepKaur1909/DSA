import java.util.*;

class Node{
    int data;
    Node next;

    Node(int d, Node n){
        this.data = d;
        this.next = n;
    }

    Node(int d){
        this.data = d;
        this.next = null;
    }
}

public class LengthOfLinkedList {

    public static int LengthLL(Node head){
        Node temp = head;
        int length = 0;
        while(temp != null){
           length += 1;
           temp = temp.next;     
        }

        return length;
    }

    public static Node createLL(int [] nums){
        Node head = new Node(nums[0]);
        Node mover = head;

        for(int i = 1; i<nums.length; i++){
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.print("Enter size for array: ");
       int size = input.nextInt();

       int [] nums = new int[size];
       System.out.println("Enter elements for array: ");
       for(int i = 0; i<size; i++){
           nums[i] = input.nextInt();
       }

       Node head = createLL(nums);

       System.out.println("Length of LinkedList: " + LengthLL(head));
       input.close();
    }
}
