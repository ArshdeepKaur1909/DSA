import java.util.Scanner;

public class OddEvenLinkedList {

    public static void traverseLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node createLL(int [] nums){
        Node head = new Node(nums[0]);
        Node prev = head;
        for(int i = 1; i<nums.length; i++){
            Node temp = new Node(nums[i]);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    // Time Complexity: O(N) and Space Complexity: O(1)
    public static Node oddEvenList(Node head){
        if(head == null || head.next == null){
           return head;
        }

        Node odd = head;
        Node even  = head.next;
        Node evenHead = even;

        while((even != null && even.next != null) && (odd != null && odd.next != null)){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size of Linked List: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        System.out.println("Enter elements for Linked List: ");
        for(int i = 0; i<size; i++){
           nums[i] = input.nextInt();
        }
        Node head = createLL(nums);
        System.out.println("Original Linked List: ");
        traverseLL(head);

        System.out.println();

        System.out.println("Linked List after Odd-Even rearrangement: ");
        head = oddEvenList(head);
        traverseLL(head);
        input.close();
    }
}