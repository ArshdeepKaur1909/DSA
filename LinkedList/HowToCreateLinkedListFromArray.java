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

public class HowToCreateLinkedListFromArray {
    
    public static Node createLinkedList(int [] nums){
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

       System.out.println("Enter size for array: ");
       int size = input.nextInt();

       int [] nums = new int[size];
       System.out.println("Enter Elements for Array: ");
       for(int i = 0; i<size; i++){
           nums[i] = input.nextInt();
       }

       System.out.println("Array -> LinkedList " + createLinkedList(nums).data);
       input.close();
    }
}
