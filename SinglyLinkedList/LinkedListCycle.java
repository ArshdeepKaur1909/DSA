import java.util.*;

public class LinkedListCycle {

    //Optimal Approach -> Time Complexity: O(n), Space Complexity: O(1)
    public static boolean detectCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }

    //Brute Force Approach -> Function to detect cycle in a linkedlist -> Time Complexity: O(n), Space Complexity: O(n)
    /* public static boolean detectCycle(Node head){
        Node temp = head;
        HashSet<Node> set = new HashSet<>();

        while(temp != null){
          if(set.contains(temp)) return true;
          set.add(temp);
          temp = temp.next;
        }
        return false;
    } */

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

       System.out.println("Does the LinkedList contains a cycle? " + detectCycle(head));
    }
}