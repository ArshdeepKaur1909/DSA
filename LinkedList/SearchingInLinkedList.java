import java.util.Scanner;

public class SearchingInLinkedList {

    public static int searchTargetLL(Node head, int target){
        Node temp = head;
        int index = -1;
        while(temp != null){
           index += 1;
           if(temp.data == target) return index;
           temp = temp.next;
        }

        return -1;
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

        System.out.print("Enter a target that needs to be searched: ");
        int target = input.nextInt();

        System.out.println("Index at which target is present in LinkedList: " + searchTargetLL(head, target));
        input.close();
    }
}
