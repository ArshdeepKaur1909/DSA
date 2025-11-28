import java.util.*;

public class FindFirstAndLastElementIndex {
    // Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    // If target is not found in the array, return [-1, -1]

    private static int searchFirst(int [] nums, int target){
        int n = nums.length;
        
        if(nums[0] == target) return 0;
        
        if(nums[0] > target) return -1;

        if(nums[n-1] < target) return -1;

        int low = 0; 
        int high = n - 1;
        int first = -1;

        while(low <= high){
          int mid = (low + high)/2;
          
          if(nums[mid] >= target){
            if(nums[mid] == target) first = mid;
            high = mid - 1;
          }

          else{
            low = mid + 1;
          }
        }

        return first;
    }

    private static int searchLast(int [] nums, int target){
        int n = nums.length;
        
        if(nums[n-1] == target) return n-1;
        
        if(nums[0] > target) return -1;

        if(nums[n-1] < target) return -1;

        int low = 0; 
        int high = n - 1;
        int last = -1;

        while(low <= high){
          int mid = (low + high)/2;
          
          if(nums[mid] >target){
            high = mid - 1;
          }

          else{
            if(nums[mid] == target) last = mid;
            low = mid + 1;
          }
        }

        return last;
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] range = new int[2];

        if(nums.length == 0){
            range[0] = -1;
            range[1] = -1;
            return range;
        }
        range[0] = searchFirst(nums, target);
        range[1] = searchLast(nums, target);

        return range;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int [] nums = new int[size];

        System.out.println("Enter the elements of array in sorted order: ");
        for(int i = 0; i < size; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("Enter the target value: ");
        int target = input.nextInt();

        System.out.println("Floor and Ceil values for target are: " + Arrays.toString(searchRange(nums, target)));

        input.close();
    }
}
