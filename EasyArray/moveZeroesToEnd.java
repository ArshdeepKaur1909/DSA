import java.util.*;

public class moveZeroesToEnd{
    
    //Optimal Approach => Time Complexity = O(N) and Space Complexity = O(1)
    public static void MoveZeroesToEnd(int [] nums){
        if (nums.length == 1) return;

        int i = -1;
        for(int k = 0; k<nums.length; k++){
            if(nums[k] == 0){
                i = k;
                break;
            }
        }

        if(i == -1) return;

        for(int j = i+1; j<nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    //Brute Force Approach => Time Complexity = O(2N) and Space Complexity = O(N)
    // public static void MoveZeroesToEnd(int [] nums){
    //   if(nums.length == 1) return;

    //   int [] temp = new int[nums.length];

    //   int i = 0;
    //   for(int k = 0; k<nums.length; k++){
    //     if(nums[k] == 0) continue;
    //     else{
    //        temp[i] = nums[k];
    //        i++;
    //     } 
    //   }
      
    //   if(i == 0) return;

    //   for(int k = 0; k<i; k++){
    //      nums[k] = temp[k]; 
    //   }

    //   for(int k = i; k<nums.length; k++){
    //     nums[k] = 0;
    //   }
    // }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }
        
        MoveZeroesToEnd(nums);
        System.out.println("Array after moving zeroes to end: " + Arrays.toString(nums));

        input.close();
    }
}