import java.util.*;
public class CheckLinkedListIsPallindrome {

    // Optimal Approach: Time Complexity: O(n) and Space Complexity: O(1)
    public static Node reverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static boolean isPalindrome(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
              slow = slow.next;
              fast = fast.next.next;
        }

        if(fast == null){
            Node tail = reverseLL(slow);
            Node temph = head;
            Node tempt = tail;

            while(tempt != null){
                if(tempt.data == temph.data){
                    tempt = tempt.next;
                    temph = temph.next;
                }
                else{
                    reverseLL(tail); // Optional: To restore the original linked list;
                    return false;
                }
            }

            reverseLL(tail);
        }

        else if(fast.next == null){
            Node tail = reverseLL(slow.next);
            Node temph = head;
            Node tempt = tail;

            while(tempt != null){
                if(tempt.data == temph.data){
                    tempt = tempt.next;
                    temph = temph.next;
                }
                else{
                    reverseLL(tail); // Optional: To restore the original linked list;
                    return false;
                }
            }

            reverseLL(tail);
        }
        return true;
    }

    // Brute Force Approach: Using Stack => Time Complexity: O(n) and Space Complexity: O(n/2)
    /* public static boolean isPalindrome(Node head){
        Node slow = head;
        Node fast = head;

        // Time Complexty: O(n/2)
        while(fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
        }

        // Time Complexity: O(n) and Space Complexity: O(n/2)
        if(fast == null){
            Node temp = head;
            Stack<Integer> stack = new Stack<>();

            while(temp != slow){
                stack.push(temp.data);
                temp = temp.next;
            }

            while(temp != null){
                if(temp.data == stack.peek()){
                    temp = temp.next;
                    stack.pop();
                }else return false;
            }
        }

        else if(fast.next == null){
           Node temp = head;
           Stack<Integer> stack = new Stack<>();

           while(temp != slow.next){
              stack.push(temp.data); 
              temp = temp.next;
           }
           temp = slow; 
           while(temp != null){
              if(temp.data == stack.peek()){
                temp = temp.next;
                stack.pop();
              }else return false;
           }
        }

        return true;
    } */

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
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        System.out.println("Enter elements for array, preffered pallindrome style: ");
        int [] nums = new int[size];

        for(int i = 0; i<size; i++){
           nums[i] = input.nextInt();
        }

        Node head = createLL(nums);

        System.out.println("Linked List created with given elements is pallindrome or not: " + isPalindrome(head));
        input.close();
    }
}
