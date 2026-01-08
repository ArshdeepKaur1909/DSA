import java.util.*;

public class LengthOfALoop {
    public static int lengthOfLoop(Node head){
      Node slow = head;
      Node fast = head;
      int length = 1;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
          fast = fast.next;
          while(slow != fast){
            fast = fast.next;
            length++;
          }
          return length;
        }
      }
      return 0;
    }

    public static void setTailNext(Node tail, Node head, int poc){
      Node temp = head;
      int count = 1;
      while(count <= poc){
        if(count == poc) tail.next = temp;
        count++;
        temp = temp.next;
      }
    }
    
    public static Node createLLwithCycle(int [] nums, int poc){
      // poc => point of cycle
      Node head = new Node(nums[0]);
      Node prev = head;
      for(int i = 1; i<nums.length; i++){
        Node temp = new Node(nums[i]);
        prev.next = temp;
        prev = temp;
      }
      //prev is tailing node
      setTailNext(prev, head, poc);

      return head;
    }
    public static void main(String [] args){
      Scanner input = new Scanner(System.in);

      System.out.println("Enter size for array: ");
      int size = input.nextInt();

      int [] nums = new int[size];
      System.out.println("Enter Elements for Array: ");
      for(int i = 0; i<size; i++){
           nums[i] = input.nextInt();
      }

      Node head = createLLwithCycle(nums, 3);

      System.out.println("Length of loop in LinkedList: " + lengthOfLoop(head));
      input.close();
    }
}
