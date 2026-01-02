import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;

    Node(int d, Node n, Node p){
        this.data = d;
        this.next = n;
        this.prev = p;
    }

    Node(int d){
        this.data = d;
        this.next = null;
        this.prev = null;
    }
}

public class DeletionInLL {

    public static Node deleteAtPosition(Node head, int k){
        if(k == 1){
           if(head == null || head.next == null){
            return null;
          }

           head.next.prev = null;
           return head.next;
        }

        if(k > LengthDLL(head)){
            System.out.println("Invalid Position");
            return head;
        }

        Node temp = head;
        int count = 1;
        while(count <= k){
            if(count == k){
               temp.prev.next = temp.next;
               if(temp.next != null){
                 temp.next.prev = temp.prev; 
               }
               break;
            }
            count ++;
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteHead(Node head){
        if(head == null || head.next == null){
            return null;
        }

        head.next.prev = null;
        return head.next;
    }

    public static Node createDLL(int [] nums){
        Node head = new Node(nums[0]);
        Node prev = head;
        for(int i = 1; i<nums.length; i++){
            Node temp = new Node(nums[i], null, prev);
            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    
    public static void displayDLL(Node head){
        Node temp = head;
        System.out.print("null <- ");
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static int LengthDLL(Node head){
        int count = 1;
        Node temp = head;

        while(temp != null){
            count ++;
            temp = temp.next;
        }

        return count;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        System.out.println("Enter elements for array: ");
        int [] nums = new int[size];
        for(int i = 0; i<size; i++){
            nums[i] = input.nextInt();
        }
 
        Node head = createDLL(nums);

        System.out.println("Doubly Linked List before Deletion: ");
        displayDLL(head);

        System.out.println("Doubly Linked List after Deletion of head: ");
        head = deleteHead(head);
        displayDLL(head);

        System.out.println("Enter position k to delete node at position k: ");
        int k = input.nextInt();

        System.out.println("Doubly Linked List after Deletion at position k: ");
        head = deleteAtPosition(head, k);
        displayDLL(head);
        
        input.close();
    }
}