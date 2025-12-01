import java.util.*;

public class SearchInLeftRotatedArray{
    
    public static void reverse(int [] nums, int start, int end){
        if (nums.length == 1) return;

        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    // Optimal Approach => Time Complexity = O(2n) and Space Complexity = O(1)
    public static void LeftRotateByD(int [] nums, int d){
        int n = nums.length;
        d = d%n;

        if(d == 0 || n == 1) return;

        reverse(nums, 0, d-1);
        reverse(nums, d, n-1);
        reverse(nums, 0, n-1);
    }

    // Time Complexity = O(log n) and Space Complexity = O(1)
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        // Code for no duplicates present in array
        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target) return mid;

            // left array is sorted 
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            // right array is sorted
            else{
               if(nums[mid] <= target && target <= nums[high]){
                  low = mid + 1;
               }else{
                   high = mid - 1; 
               }
            }
        }

        return -1;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        System.out.println("Enter elements for array in sorted manner: ");
        for(int i = 0; i<size; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("Enter the places by which you want to left rotate the sorted array: ");
        int places = input.nextInt();

        LeftRotateByD(nums, places);

        System.out.println("The left rotated array is: ");
        for(int i = 0; i<size; i++){
            System.out.println(nums[i] + " ");
        }

        System.out.println("Enter the target that needs to be searched in left rotated array: ");
        int target = input.nextInt();

        System.out.println("Index of target element in array is: " + search(nums, target));


        input.close();
    }
}