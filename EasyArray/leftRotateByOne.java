import java.util.*;

public class leftRotateByOne{
    
    // Time Complexity = O(n) Space Complexity = O(1) but if we consider we are using an array for solving problem then Space Complexity = O(n)
    public static void LeftRotateByOne(int [] nums){
     int temp = nums[0];
     
    for(int i = 1; i<nums.length; i++){
        nums[i-1] = nums[i];
    }

        nums[nums.length - 1] = temp;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }
        
        System.out.println("Array Entered: " + Arrays.toString(nums));

        LeftRotateByOne(nums);
        System.out.println("After Rotating Array Left By One Place: " + Arrays.toString(nums));

        input.close();
    }
}