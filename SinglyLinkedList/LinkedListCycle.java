import java.util.*;

public class LinkedListCycle {

    public static void traverseLL(Node head){
       Node temp = head;
       // we have to traverse till temp becomes null 
       while(temp != null){
          System.out.print(temp.data + " -> "); 
          temp = temp.next;
       }
       System.out.println("null");
    }

    public static Node createLL(int [] nums){
        if(nums.length == 0) return null;
        Node head = new Node(nums[0]);
        Node mover = head;

        for(int i = 1; i<nums.length; i++){
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = mover.next; 
        }

        return head;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

       System.out.println("Enter number of elements you want in LinkedList: ");
       int size = input.nextInt();

       int [] nums = new int[size];
       System.out.println("Enter the elements: ");
       for(int i = 0; i<size; i++){
        nums[i] = input.nextInt();
       }

       Node head = createLL(nums);
       System.out.println("Original Linked List: ");
       traverseLL(head);
    }
}