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
public class HowToDeleteANode {

    public static void traverse(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

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

    public static int LengthLL(Node head){
        Node temp = head;
        int length = 0;
        while(temp != null){
           length += 1;
           temp = temp.next;     
        }

        return length;
    }

    public static Node deleteFromSpecificPosition(Node head, int k){
        // when position is more than Length of LinkedList
        if(k > LengthLL(head)){
            System.out.println("Invalid Position"); 
            return head;
        }
        // k == position from where node needs to be deleted
        if(k == 1){
           return head.next;
        }
        int count = 1;
        Node temp = head;
        while(count < k){
          if(count == k-1){
            temp.next = temp.next.next;
          }
          count++;
          temp = temp.next;
        }
        return head;
    }

    public static Node deleteHead(Node head){
        if(head == null || head.next == null) return null;
        head = head.next;
        return head; 
    }
    
    // public static void deleteNode(Node node){
    //     /* There is a singly-linked list head and we want to delete a node node in it. You are given the node to be deleted node. You will not be given access to the first node of head. All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list */
    //     Node prev = null;
    //     while(node.next != null){
    //         prev = node;
    //         node.data = node.next.data;
    //         node = node.next;
    //     } 
    //     prev.next = null;
    // }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        System.out.println("Enter elements for array: ");
        for(int i = 0; i<size; i++){
           nums[i] = input.nextInt();    
        }
        Node head = createLinkedList(nums);
        System.out.print("LinkedList before deletion: ");
        traverse(head);

        head = deleteHead(head);

        System.out.println();
        System.out.print("LinkedList after deletion of head: ");
        traverse(head);


        head = deleteFromSpecificPosition(head, 2);
        System.out.println();
        System.out.print("LinkedList after deletion from specific position: ");
        traverse(head);

        input.close();
    }
}
