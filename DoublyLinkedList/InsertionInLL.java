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
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class InsertionInLL {

    public static Node insertAtKthPosition(Node head, int data, int k){
        int count = 1;
        Node temp = head;

        while(count < k){
            if(count == k-1){
               Node node = new Node(data);
               node.next = temp.next;
               node.prev = temp;
               temp.next.prev = node;
               temp.next = node;
            }
            temp = temp.next;
            count++;
        }

        return head;
    }

    public static Node insertAtHead(Node head, int data){
        Node node = new Node(data);
        node.next = head;
        head.prev = node;
        return node;
    }

    public static Node createDoubleLinkedList(int [] nums){
        Node head = new Node(nums[0]);
        Node prev = head;
        for(int i = 1; i<nums.length; i++){
            Node temp = new Node(nums[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size for array: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        System.out.println("Enter elements for array: ");
        for(int i = 0; i<size; i++){
          nums[i] = input.nextInt();
        }
        // creating doubly linked list from array
        Node head = createDoubleLinkedList(nums);
        
        // Input element to be inserted
        System.out.println("Emter element to be inserted by Seerat: ");
        int element = input.nextInt();

        // Inserting element at the beginning
        head = insertAtHead(head, element);

        // Printing the linked list
        printLinkedList(head);

        // Inserting element at the position k
        head = insertAtKthPosition(head, element, 4);

        // Printing the linked list
        printLinkedList(head);
        
        input.close();
    }
}
