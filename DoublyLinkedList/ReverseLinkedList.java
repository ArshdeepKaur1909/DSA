import java.util.Scanner;

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

public class ReverseLinkedList {
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
    
    // Time Complexity: O(2n) Space Complexity: O(n)
    /* public static Node reverseDLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        Node headn = new Node(tail.data);
        Node prev = headn;
        while(tail != head){
         Node temp = new Node(tail.prev.data, null, prev);
         prev.next = temp;
         prev = temp;
         tail = tail.prev;
        }

        return headn;
    } */

    // Time Complexity: O(n) Space Complexity: O(1)    
    public static Node reverseDLL(Node head){
       Node temp = head; 
       while(temp != null){
            Node last = temp.prev;
            temp.prev = temp.next;
            temp.next = last;
            if(temp.prev != null) temp = temp.prev;
            else return temp;
       }
       return null;
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
        displayDLL(head);

        head = reverseDLL(head);
        displayDLL(head);
        input.close();
    }    
}