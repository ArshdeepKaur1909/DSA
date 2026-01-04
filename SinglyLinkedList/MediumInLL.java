import java.util.*;

public class MediumInLL {

    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
      System.out.println("LinkedList looks like this: ");
      traverse(head);

      Node mid = middleNode(head);
      System.out.println("Middle Node is: " + mid.data);

      input.close();
    }
}
