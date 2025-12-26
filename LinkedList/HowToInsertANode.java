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

public class HowToInsertANode {

    //method to insert a node at start of LinkedList
   public static Node insertAtStart(Node head, int data){
       return new Node(data, head);
   }

    //method to insert a node at a given position including at tail
   public static Node insertAtPosition(Node head, int data, int k){
        if(k == 1){
         return new Node(data, head);
        }

        if(head == null){
         return null; // tells LinkedList is empty
        }

        Node temp = head;
        int count = 1;
        while(count < k){
           if(count == k-1){
            Node latest = new Node(data, temp.next);
            temp.next = latest;
           }
           temp = temp.next;
           count++;
        }

        return head;
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

   public static void traverse(Node head){
       Node temp = head;

       while(temp != null){
          System.out.print(temp.data + " -> ");
          temp = temp.next;
       }
       System.out.print("null");
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
      System.out.print("Before inserting any extra node, LinkedList looks like this: ");
      traverse(head);
      System.out.println();

      head = insertAtStart(head, 32);
      System.out.print("After inserting extra node, LinkedList looks like this: ");
      traverse(head);

      System.out.println();

      insertAtPosition(head, size+1, size+1);
      System.out.println("After inserting extra node, LinkedList looks like this: ");
      traverse(head);

      input.close();
    }
}
