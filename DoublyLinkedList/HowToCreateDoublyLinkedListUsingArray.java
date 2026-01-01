import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data, Node n, Node p){
        this.data = data;
        this.next = n;
        this.prev = p;
    }

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class HowToCreateDoublyLinkedListUsingArray {
    
    public static Node createDoublyLinkedList(int [] nums){
       Node head = new Node(nums[0]);
       Node prev = head;

       for(int i = 1; i<nums.length; i++){
           Node temp = new Node(nums[i], null, prev);
           prev.next = temp;
           prev = temp;
       }

       return head;
    }

    public static void printDLL(Node head){
        Node temp = head;
        System.out.print("null <- ");
        while(temp != null){
           System.out.print(temp.data + " -> ");
           temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size for array: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        System.out.println("Enter the elements for array: ");
        for(int i = 0; i<size; i++){
           nums[i] = input.nextInt();
        }

        Node head = createDoublyLinkedList(nums);
        printDLL(head);

        input.close();
    }
}