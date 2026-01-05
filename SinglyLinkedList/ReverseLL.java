import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class ReverseLL {

    //Recursive Approach: Time Complexity: O(n) Space Complexity: O(n) => It is due to function call stack
    public static Node reverseLL(Node head){
      if(head.next == null) return head;
      Node newHead = reverseLL(head.next);
      Node front = head.next;
      front.next = head;
      head.next = null;

      return newHead;
    }

    // Time Complexity: O(n) Space Complexity: O(1)
    /* public static Node reverseLL(Node head){
        Node prev = null;
        Node temp = head;
        
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front; 
        }
        return prev;
    }*/

    // Time Complexity: O(2n) Space Complexity: O(n)
    /*public static Node reverseLL(Node head){
       Stack<Integer> stack = new Stack<>();

      Node temp = head;
      while(temp != null){
        stack.push(temp.data);
        temp = temp.next;
      }

      temp = head;
      while(temp != null){
        temp.data = stack.peek();
        stack.pop();
        temp = temp.next;
      }

      return head;
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
    public static void main(String[] args){
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

       head = reverseLL(head);
       System.out.println("Reversed Linked List: ");
       traverseLL(head);
       input.close();
    }
}
